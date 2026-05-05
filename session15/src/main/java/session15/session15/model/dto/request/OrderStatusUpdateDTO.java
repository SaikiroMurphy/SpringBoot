package session15.session15.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import session15.session15.utils.OrderStatus;

@Getter
@Setter
public class OrderStatusUpdateDTO {

    @NotNull(message = "status không được để trống")
    private OrderStatus status;
}
