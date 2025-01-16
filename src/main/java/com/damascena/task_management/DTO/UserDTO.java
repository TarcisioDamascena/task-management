package com.damascena.task_management.DTO;

import lombok.Data;

import java.time.ZonedDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "User data transfer object")
public class UserDTO {
    @Schema(description = "User identifier", example = "1")
    private Long id;

    @Schema(description = "Username", example = "john.doe")
    private String username;

    @Schema(description = "Username", example = "john.doe")
    private String email;

    @Schema(description = "Account creation timestamp")
    private ZonedDateTime createdAt;
}
