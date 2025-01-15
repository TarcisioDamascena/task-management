package com.damascena.task_management.exceptions;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException (String message) {
        super(message);
    }
}
