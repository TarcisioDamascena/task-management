package com.damascena.task_management.DTO;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private ZonedDateTime createdAt;
}
