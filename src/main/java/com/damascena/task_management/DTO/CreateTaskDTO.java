package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class CreateTaskDTO {
    @NotBlank
    private String title;

    private String description;

    @NotNull
    private TaskPriority priority;

    private ZonedDateTime dueDate;
}
