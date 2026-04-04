package session05.session05.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import session05.session05.model.dto.response.CourseResponseV2;
import session05.session05.model.entity.Course;
import session05.session05.utils.CourseStatus;

public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query("SELECT c FROM Course c WHERE c.status = :status")
    Page<Course> findAllByStatus(@Param("status") CourseStatus status, Pageable pageable);

    @Query("""
    SELECT new session05.session05.model.dto.response.CourseResponseV2(c.id AS id, c.title AS title, c.status AS status) 
    FROM Course c
    WHERE c.status = :status
""")
Page<CourseResponseV2> findAllByStatusV2(
    @Param("status") CourseStatus status,
    Pageable pageable
);
}
