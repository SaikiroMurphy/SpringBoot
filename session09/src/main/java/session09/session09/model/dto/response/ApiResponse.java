package session09.session09.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import session09.session09.utils.enums.ApiStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private ApiStatus status; 
    private String message;
    private T data;
}
