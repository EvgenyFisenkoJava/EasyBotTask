package com.example.easybottask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ArgumentException.class)
    public ResponseEntity<ErrorResponse> handleMyException(ArgumentException ex) {
        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static class ErrorResponse {
        private final HttpStatus status;
        private final List<String> errors;

        public ErrorResponse(HttpStatus status, List<String> errors) {
            this.status = status;
            this.errors = errors;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public List<String> getErrors() {
            return errors;
        }
    }
}
