package com.example.hoche.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.hoche.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getStatusCode())
                .title(ex.getTitle())
                .msg(ex.getMsg())
                .build();
        return ResponseEntity.status(ex.getHttpStatusCode()).body(errorResponse);
    }


}
