package Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle StudentNotFoundException
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException ex) {
        // Create a response body with custom error fields
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());  // HTTP 404 status code
        errorResponse.put("error", "Student Not Found");
        errorResponse.put("message", ex.getMessage());  // Include exception message (e.g., "Student not found")
        errorResponse.put("details", "The student with the given name or address was not found in the system.");

        // Return response with customized error body
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Handle Generic Exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        // Create a response body for generic exceptions
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());  // HTTP 500 status code
        errorResponse.put("error", "Internal Server Error");
        errorResponse.put("message", ex.getMessage());  // Include the exception message
        errorResponse.put("details", "An unexpected error occurred. Please try again later.");

        // Return response with customized error body
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
