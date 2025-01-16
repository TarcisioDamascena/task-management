package com.damascena.task_management.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "User login credentials")
public class UserLoginDTO {
    @Schema(description = "Username", example = "john.doe", required = true)
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Schema(description = "Password", example = "securePassword123", required = true)
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
