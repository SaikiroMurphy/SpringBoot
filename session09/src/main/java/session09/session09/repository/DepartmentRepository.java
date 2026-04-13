package session09.session09.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session09.session09.model.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
