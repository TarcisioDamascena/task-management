package com.damascena.task_management.controller;

import com.damascena.task_management.DTO.CreateTaskDTO;
import com.damascena.task_management.DTO.TaskDTO;
import com.damascena.task_management.DTO.UpdateTaskDTO;
import com.damascena.task_management.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@Valid @RequestBody CreateTaskDTO createTaskDTO) {
        return ResponseEntity.ok(taskService.createTask(createTaskDTO));
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getUserTasks() {
        return ResponseEntity.ok(taskService.getCurrentUserTasks());
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long taskId, @Valid @RequestBody UpdateTaskDTO updateTaskDTO) {
        return ResponseEntity.ok(taskService.updateTask(taskId, updateTaskDTO));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
