package session06.session06.model.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parking_tickets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParkingTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "check_in_time", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime checkOutTime;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "zone_id", nullable = false)
    private Zone zone;
}
