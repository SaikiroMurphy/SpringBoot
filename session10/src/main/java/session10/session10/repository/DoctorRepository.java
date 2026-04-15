package session10.session10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session10.session10.model.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
