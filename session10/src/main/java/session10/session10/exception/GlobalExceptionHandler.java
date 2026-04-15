package session10.session10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import session10.session10.model.dto.response.ApiResponse;
import session10.session10.utils.enums.ApiResponseStatusEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> EntityNotFoundExceptionHandler(EntityNotFoundException e) {
        ApiResponse<String> res = new ApiResponse<>(ApiResponseStatusEnum.FAIL, 404, e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
}
