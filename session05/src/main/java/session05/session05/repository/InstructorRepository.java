package session05.session05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session05.session05.model.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
