package session06.session06.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session06.session06.utils.VehicleType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VehicleResponse {
    private String id;
    private String licensePlate;
    private String color;
    private VehicleType vehicleType;
}
