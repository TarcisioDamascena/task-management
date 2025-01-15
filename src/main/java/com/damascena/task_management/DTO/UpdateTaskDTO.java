package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UpdateTaskDTO {
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private ZonedDateTime dueDate;
}
