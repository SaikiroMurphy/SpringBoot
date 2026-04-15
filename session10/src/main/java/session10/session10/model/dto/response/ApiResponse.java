package session10.session10.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session10.session10.utils.enums.ApiResponseStatusEnum;

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
