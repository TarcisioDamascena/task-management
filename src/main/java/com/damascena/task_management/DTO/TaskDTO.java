package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Schema(description = "Task data transfer object")
public class TaskDTO {
    @Schema(description = "Task identifier", example = "1")
    private Long id;

    @Schema(description = "Task title", example = "Complete project documentation")
    private String title;

    @Schema(description = "Task description", example = "Write comprehensive documentation for the API")
    private String description;

    @Schema(description = "Current task status", example = "IN_PROGRESS")
    private TaskStatus status;

    @Schema(description = "Task priority level", example = "HIGH")
    private TaskPriority priority;

    @Schema(description = "Task due date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime dueDate;

    @Schema(description = "Task creation timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime createdAt;

    @Schema(description = "Last update timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime updatedAt;
}
