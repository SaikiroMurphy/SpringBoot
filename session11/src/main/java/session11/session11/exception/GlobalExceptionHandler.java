package session11.session11.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import session11.session11.model.dto.response.ApiResponse;
import session11.session11.utils.enums.ApiResponseStatusEnum;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleAllException(Exception e) {
        log.error("Đã xảy ra lỗi hệ thống: ", e);

        ApiResponse<String> response = new ApiResponse<>(
                ApiResponseStatusEnum.FAIL,
                500,
                "Đã xảy ra lỗi hệ thống, vui lòng thử lại sau!",
                null);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> EntityNotFoundExceptionHandler(EntityNotFoundException e) {
        ApiResponse<String> res = new ApiResponse<>(ApiResponseStatusEnum.FAIL, 404, e.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }
}
