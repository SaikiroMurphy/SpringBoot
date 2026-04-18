package session11.session11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session11.session11.model.entity.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{

}
