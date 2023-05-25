package com.example.demo19.ApiException;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.zip.DataFormatException;

public class AllException {

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Exception> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new Exception(msg));

    }


    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Exception> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new Exception(msg));
    }


    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Exception> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new Exception(msg));
    }


    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Exception> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String msg = e.getMessage();
        return ResponseEntity.status(400).body(new Exception(msg));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> ApiException(Exception e){
        String message=e.getMessage();
        return ResponseEntity.status(400).body(message);

    }


    @ExceptionHandler(DataFormatException.class)
    public ResponseEntity<Exception> handleDataAccessException(DataAccessException e) {
        String message = "An error occurred while accessing the data: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Exception(message));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Exception> handleEntityNotFoundException(EntityNotFoundException e) {
        String message = "The requested entity was not found: " + e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Exception(message));
    }
}
