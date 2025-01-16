package com.damascena.task_management.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "User registration data")
public class UserRegistrationDTO {
    @Schema(description = "Username", example = "john.doe", required = true)
    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @Schema(description = "Password", example = "securePassword123", required = true)
    @NotBlank
    @Size(min = 6, max = 100)
    private String password;

    @Schema(description = "Email address", example = "john.doe@example.com", required = true)
    @NotBlank
    @Email
    private String email;
}
