package session12.session12.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session12.session12.enums.ApiStatus;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {
    private ApiStatus status;

    private String message;

    private T data;

    private PageResponse meta;
}
