package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Schema(description = "Data for updating an existing task")
public class UpdateTaskDTO {
    @Schema(description = "Updated task title", example = "Complete project documentation")
    private String title;
    
    @Schema(description = "Updated task description", example = "Write comprehensive documentation for the API")
    private String description;
    
    @Schema(description = "Updated task status", example = "IN_PROGRESS")
    private TaskStatus status;
    
    @Schema(description = "Updated task priority", example = "HIGH")
    private TaskPriority priority;
    
    @Schema(description = "Updated due date")
    private ZonedDateTime dueDate;
}
