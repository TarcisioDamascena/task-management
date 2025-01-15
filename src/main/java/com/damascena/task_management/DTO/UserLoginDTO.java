package com.damascena.task_management.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
