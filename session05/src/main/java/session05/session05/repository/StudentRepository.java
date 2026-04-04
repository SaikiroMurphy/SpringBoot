package session05.session05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session05.session05.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
