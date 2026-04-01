package session04.session04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session04.session04.model.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
