package com.company.exception;

public class InvalidIMCException extends RuntimeException {
    public InvalidIMCException(String message) {
        super(message);
    }
}