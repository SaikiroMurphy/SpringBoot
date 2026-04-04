package session06.session06.model.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import session06.session06.utils.VehicleType;

@Entity
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "license_plate", nullable = false, unique = true)
    private String licensePlate;

    @Column()
    private String color;
    
    @Column()
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @OneToMany(mappedBy = "vehicle")
    private List<ParkingTicket> parkingTickets;
}
