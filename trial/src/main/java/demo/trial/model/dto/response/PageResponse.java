package session11.session11.model.dto.response;

import lombok.*;

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
