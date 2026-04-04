package session05.session05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session05.session05.model.entity.EnrollmentId;
import session05.session05.model.entity.StudentEnrollment;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, EnrollmentId>{

}
