package session07.session07.exception;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import session07.session07.model.dto.response.ApiRespone;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiRespone<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> result = ex.getBindingResult().getFieldErrors()
            .stream()
            .collect(Collectors.toMap(
                    error -> error.getField(),
                    error -> error.getDefaultMessage(),
                    (oldValue, newValue) -> oldValue // tránh trùng key
            ));

    ApiRespone<Map<String, String>> response = new ApiRespone<>();
    response.setStatus("400 BAD_REQUEST");
    response.setMessage("Validation failed");
    response.setData(result);

    return ResponseEntity.badRequest().body(response);
    }
}
