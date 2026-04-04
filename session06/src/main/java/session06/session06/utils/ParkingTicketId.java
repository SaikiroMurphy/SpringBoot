package session06.session06.utils;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingTicketId {
    @Column(name = "zone_id", nullable = false)
    private String zoneId;

    @Column(name = "vehicle_id", nullable = false)
    private String vehicleId;
}
