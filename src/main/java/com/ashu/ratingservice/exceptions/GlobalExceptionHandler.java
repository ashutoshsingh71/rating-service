package com.ashu.ratingservice.exceptions;

import com.ashu.ratingservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(RuntimeException ex){
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .message(ex.getMessage())
                        .success(false)
                        .httpStatus(HttpStatus.OK)
                        .build());
    }
}
