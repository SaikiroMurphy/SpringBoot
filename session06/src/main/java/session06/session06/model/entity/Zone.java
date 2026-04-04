package session06.session06.model.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "zones")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private int capacity;

    @Column(name = "occupied_spots")
    private int occupiedSpots;

    @OneToMany(mappedBy = "zone")
    private List<ParkingTicket> parkingTickets;
}
