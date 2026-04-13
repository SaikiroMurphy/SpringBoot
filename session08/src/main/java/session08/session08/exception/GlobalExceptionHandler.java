package session08.session08.exception;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import session08.session08.model.dto.response.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorResponse> handleIOException(IOException exception) {
        return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new ErrorResponse(400, "IOException", LocalDateTime.now()));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(new  ErrorResponse(404, "ResourceNotFound", LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(new ErrorResponse(400, "MethodArgumentNotValidException", LocalDateTime.now()));
    }

}
