package com.example.keka.exception;

// Import Map for constructing JSON error responses.
import java.util.Map;

// Import exception thrown when validation fails.
import org.springframework.web.bind.MethodArgumentNotValidException;

// Import exception thrown when a requested task doesn't exist.
import java.util.NoSuchElementException;

// Import HTTP status codes.
import org.springframework.http.HttpStatus;

// Import ResponseEntity.
import org.springframework.http.ResponseEntity;

// Import exception-handling annotations.
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// @RestControllerAdvice handles exceptions globally
// across all REST controllers in the application.
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handles invalid request data.
    // For example, a blank task title.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException exception) {

        // Extract the validation error message.
        String errorMessage = exception.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        // Create a JSON-friendly error response.
        Map<String, String> errorResponse = Map.of(
                "error", errorMessage
        );

        // Return HTTP 400 Bad Request.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }

    // Handles requests for tasks that do not exist.
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(
            NoSuchElementException exception) {

        // Create an error response using the exception message.
        Map<String, String> errorResponse = Map.of(
                "error", exception.getMessage()
        );

        // Return HTTP 404 Not Found.
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }
}

