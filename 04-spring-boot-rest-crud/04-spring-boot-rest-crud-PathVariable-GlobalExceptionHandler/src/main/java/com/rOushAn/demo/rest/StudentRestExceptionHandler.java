package com.rOushAn.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the REST API.
 * This class handles exceptions thrown by controller methods and provides meaningful HTTP responses.
 */
@ControllerAdvice // Enables centralized exception handling across all controllers.
public class StudentRestExceptionHandler {

    /**
     * Handles `StudentNotFoundException` specifically.
     * This method constructs a custom error response with a NOT_FOUND status.
     *
     * @param exc the exception thrown when a student is not found
     * @return a ResponseEntity containing the custom error response and HTTP status
     */
    @ExceptionHandler // Marks this method as an exception handler for `StudentNotFoundException`.
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        // Create a custom error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value()); // HTTP status code 404 (NOT_FOUND)
        error.setMessage(exc.getMessage()); // Set the error message from the exception
        error.setTimestamp(System.currentTimeMillis()); // Set the current system time as the timestamp

        // Return the error response wrapped in a ResponseEntity with NOT_FOUND status
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles any other exceptions that are not specifically handled.
     * This method provides a generic error response with a BAD_REQUEST status.
     *
     * @param exc the exception thrown during processing
     * @return a ResponseEntity containing the custom error response and HTTP status
     */
    @ExceptionHandler // Marks this method as an exception handler for general exceptions.
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        // Create a generic error response
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value()); // HTTP status code 400 (BAD_REQUEST)
        error.setMessage(exc.getMessage()); // Set the error message from the exception
        error.setTimestamp(System.currentTimeMillis()); // Set the current system time as the timestamp

        // Return the error response wrapped in a ResponseEntity with BAD_REQUEST status
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
