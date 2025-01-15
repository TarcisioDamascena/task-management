package com.damascena.task_management.DTO;


import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private ZonedDateTime dueDate;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
