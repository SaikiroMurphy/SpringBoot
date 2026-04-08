package session07.session07.model.dto.response;

import lombok.Data;

@Data
public class ApiRespone<T> {
    private String status;
    private String message;
    private T data;
}
