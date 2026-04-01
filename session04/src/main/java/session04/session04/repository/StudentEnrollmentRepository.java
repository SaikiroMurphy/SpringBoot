package session04.session04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session04.session04.model.entity.EnrollmentId;
import session04.session04.model.entity.StudentEnrollment;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, EnrollmentId>{

}
