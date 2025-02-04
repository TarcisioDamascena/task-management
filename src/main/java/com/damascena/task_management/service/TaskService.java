package com.damascena.task_management.service;


import com.damascena.task_management.DTO.CreateTaskDTO;
import com.damascena.task_management.DTO.TaskDTO;
import com.damascena.task_management.DTO.UpdateTaskDTO;
import com.damascena.task_management.entity.Task;
import com.damascena.task_management.entity.User;
import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;
import com.damascena.task_management.exceptions.ResourceNotFoundException;
import com.damascena.task_management.exceptions.UnauthorizedAccessException;
import com.damascena.task_management.repository.TaskRepository;
import com.damascena.task_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.chrono.ChronoZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Transactional
    public TaskDTO createTask(CreateTaskDTO createTaskDTO) {
        User user = getCurrentUser();

        Task task = new Task();
        task.setTitle(createTaskDTO.getTitle());
        task.setDescription(createTaskDTO.getDescription());
        task.setStatus(TaskStatus.TODO);
        task.setPriority(createTaskDTO.getPriority());
        task.setDueDate(createTaskDTO.getDueDate());
        task.setUser(user);

        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> getCurrentUserTasks() {
        User user = getCurrentUser();
        return taskRepository.findByUserIdOrderByCreatedAtDesc(user.getId())
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public TaskDTO updateTask(Long taskId, UpdateTaskDTO updateTaskDTO) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (!task.getUser().getId().equals(getCurrentUser().getId())) {
            throw new UnauthorizedAccessException("You don't have permission to update this task");
        }

        if (updateTaskDTO.getTitle() != null) {
            task.setTitle(updateTaskDTO.getTitle());
        }
        if (updateTaskDTO.getDescription() != null) {
            task.setDescription(updateTaskDTO.getDescription());
        }
        if (updateTaskDTO.getStatus() != null) {
            task.setStatus(updateTaskDTO.getStatus());
        }
        if (updateTaskDTO.getPriority() != null) {
            task.setPriority(updateTaskDTO.getPriority());
        }
        if (updateTaskDTO.getDueDate() != null) {
            task.setDueDate(updateTaskDTO.getDueDate());
        }

        Task updatedTask = taskRepository.save(task);
        return convertToDTO(updatedTask);
    }

    @Transactional
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (!task.getUser().getId().equals(getCurrentUser().getId())) {
            throw new UnauthorizedAccessException("You don't have permission to delete this task");
        }

        taskRepository.delete(task);
    }

    private User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<TaskDTO> filterTasks(TaskStatus status, TaskPriority priority, LocalDate dueDateBefore) {
        User user = getCurrentUser();
        List<Task> filteredTasks = findFilteredTasks(user.getId(), status, priority, dueDateBefore);

        return filteredTasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private List<Task> findFilteredTasks(Long userId, TaskStatus status, TaskPriority priority, LocalDate dueDateBefore) {
        List<Task> userTasks = getCurrentUserTasks()
                .stream()
                .map(taskDTO -> taskRepository.findById(taskDTO.getId()).orElseThrow())
                .toList();

        return userTasks.stream()
                .filter(task ->
                        (status == null || task.getStatus() == status) &&
                                (priority == null || task.getPriority() == priority) &&
                                (dueDateBefore == null || task.getDueDate().isBefore(ChronoZonedDateTime.from(dueDateBefore)))
                )
                .collect(Collectors.toList());
    }
}