package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import com.damascena.task_management.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Schema(description = "Data for creating a task")
public class CreateTaskDTO {
    @Schema(description = "Create task title", example = "Complete project documentation")
    private String title;

    @Schema(description = "Create task description", example = "Write comprehensive documentation for the API")
    private String description;

    @Schema(description = "Create task status", example = "IN_PROGRESS")
    private TaskStatus status;

    @Schema(description = "Create task priority", example = "HIGH")
    private TaskPriority priority;

    @Schema(description = "Create due date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime dueDate;
}
