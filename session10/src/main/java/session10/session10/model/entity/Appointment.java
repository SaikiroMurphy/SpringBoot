package session10.session10.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.*;
import session10.session10.utils.enums.AppointmentStatusEnum;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "appointment_time", nullable = false)
    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatusEnum status;

    private String reason;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
