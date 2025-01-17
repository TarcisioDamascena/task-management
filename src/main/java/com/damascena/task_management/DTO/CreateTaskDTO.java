package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Schema(description = "Data for creating a new task")
public class CreateTaskDTO {
    @Schema(description = "Task title", example = "Complete project documentation", required = true)
    @NotBlank
    private String title;

    @Schema(description = "Task description", example = "Write comprehensive documentation for the API")
    private String description;

    @Schema(description = "Task priority level", example = "HIGH", required = true) 
    @NotNull
    private TaskPriority priority;

    @Schema(description = "Task due date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private ZonedDateTime dueDate;
}
