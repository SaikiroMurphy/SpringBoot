package session09.session09.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import session09.session09.model.dto.response.ApiResponse;
import session09.session09.utils.enums.ApiStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getFieldErrors().forEach(err -> {errors.put(err.getField(), err.getDefaultMessage());});
        ApiResponse<Map<String, String>> res = new ApiResponse<>(ApiStatus.FAIL, "Dữ liệu không hợp lệ", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> MethodArgumentNotValidExceptionHandler(EntityNotFoundException e) {
        ApiResponse<String> res = new ApiResponse<>(ApiStatus.FAIL, "Không tìm thấy dữu liệu", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

}
