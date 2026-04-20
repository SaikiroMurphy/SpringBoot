package session12.session12.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import session12.session12.enums.ApiStatus;
import session12.session12.model.dto.response.ApiResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> entityNotFoundException(EntityNotFoundException ex) {
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(session12.session12.enums.ApiStatus.FAILED);
        response.setMessage("Không tìm thấy thực thể: " + ex.getMessage());
        log.error("Entity not found: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getDefaultMessage());
        });

        ApiResponse<Map<String, String>> res = new ApiResponse<>();
        res.setStatus(ApiStatus.FAILED);
        res.setMessage("Không hợp lệ: Vui lòng kiểm tra lại các trường dữ liệu");
        res.setData(errors);

        log.error("Validation error: {}", errors, ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }

    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<ApiResponse<String>> handleGeneralException(Exception ex) {
    //     ApiResponse<String> response = new ApiResponse<>();
    //     response.setStatus(session12.session12.enums.ApiStatus.FAILED);
    //     response.setMessage("Đã xảy ra lỗi: " + ex.getMessage());
    //     log.error("An error occurred: {}", ex.getMessage(), ex);
    //     return ResponseEntity.status(500).body(response);
    // }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<String>> handleIllegalArgumentException(IllegalArgumentException ex) {

        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(session12.session12.enums.ApiStatus.FAILED);
        response.setMessage("Đối số không hợp lệ: " + ex.getMessage());

        log.error("Invalid argument: {}", ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ApiResponse<String>> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex) {

        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(session12.session12.enums.ApiStatus.FAILED);
        response.setMessage("Media type không được hỗ trợ: " + ex.getContentType());

        log.error("HTTP media type not supported: {}", ex.getMessage(), ex);

        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handle(HttpMessageNotReadableException e) {
        log.warn("Client gửi field không hợp lệ", e);
        return ResponseEntity.badRequest().body("Request chứa field không hợp lệ");
    }
    
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleNoResourceFound(
            NoResourceFoundException e,
            HttpServletRequest request) {

        String url = request.getRequestURL().toString();

        ApiResponse<String> res = new ApiResponse<>();
        res.setStatus(session12.session12.enums.ApiStatus.FAILED);
        res.setMessage("Không tìm thấy endpoint: " + url);
        
        log.error("No resource found for URL: {}", url, e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<String>> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex,
            HttpServletRequest request) {

        String url = request.getRequestURL().toString();
        String method = request.getMethod();

        ApiResponse<String> res = new ApiResponse<>();
        res.setStatus(session12.session12.enums.ApiStatus.FAILED);
        res.setMessage("Phương thức yêu cầu không được hỗ trợ: " + method + " cho endpoint: " + url);

        log.error("HTTP method not supported: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(res);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<ApiResponse<String>> handleHandlerMethodValidationException(HandlerMethodValidationException ex) {

        String errorMsg = ex.getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .findFirst()
                .orElse("Dữ liệu không hợp lệ");

        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(ApiStatus.FAILED);
        response.setMessage(errorMsg);

        log.warn("Validation error: {}", errorMsg, ex);

        return ResponseEntity.badRequest().body(response);
    }}
