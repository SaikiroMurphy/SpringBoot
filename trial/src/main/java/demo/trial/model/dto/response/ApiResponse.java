package session11.session11.model.dto.response;

import lombok.*;
import session11.session11.utils.ApiResponseStatusEnum;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ApiResponse<T> {
    private ApiResponseStatusEnum status;
    private int code;
    private T data;
    private PageResponse meta;
}
