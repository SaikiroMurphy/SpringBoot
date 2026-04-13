package session08.session08.model.dto.request;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookUpdateStockDTO {
    @Min(value = 0, message = "Stock phải lớn hơn 0!")
    private int stock;
}
