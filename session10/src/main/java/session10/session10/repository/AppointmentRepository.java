package session10.session10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session10.session10.model.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
