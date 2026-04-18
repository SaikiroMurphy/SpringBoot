package session11.session11.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session11.session11.utils.enums.ApiResponseStatusEnum;

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
