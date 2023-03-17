package com.ashu.ratingservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource not found!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
