package session11.session11.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageResponse {
    private int size;
    private int page;
    private Long totalElements;
    private int totalPages;
}
