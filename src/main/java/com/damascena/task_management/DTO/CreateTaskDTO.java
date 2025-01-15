package com.damascena.task_management.DTO;

import com.damascena.task_management.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
public class CreateTaskDTO {
    @NotBlank
    private String title;
    private String description;

    @NonNull
    private TaskPriority priority;
    private ZonedDateTime dueDate;
}
