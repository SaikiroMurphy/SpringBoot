package session05.session05.model.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PageResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private Long totalItems;
    private int totalPages;
    private boolean isLast;
}
