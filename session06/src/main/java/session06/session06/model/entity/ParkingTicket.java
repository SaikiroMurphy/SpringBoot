package session06.session06.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session06.session06.utils.ParkingTicketId;

@Entity
@Table(name = "parking_tickets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingTicket {
    @EmbeddedId
    private ParkingTicketId parkingTicketId;

    @Column(name = "check_in_time", nullable = false)
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @ManyToOne
    @MapsId("vehicleId")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @MapsId("zoneId")
    @JoinColumn(name = "zone_id")
    private Zone zone;
}
