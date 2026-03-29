package session03.session03.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import session03.session03.model.Course;
import session03.session03.repository.IRepository;
import session03.session03.utils.CourseStatus;

@Repository
public class CourseRepository implements IRepository<Course>{
    private final List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course("C01", "Java Basics", CourseStatus.PUBLISHED, "I01"));
        courses.add(new Course("C02", "Spring Boot Fundamentals", CourseStatus.PUBLISHED, "I02"));
        courses.add(new Course("C03", "REST API Design", CourseStatus.DRAFT, "I03"));
        courses.add(new Course("C04", "Database Integration", CourseStatus.PUBLISHED, "I04"));
        courses.add(new Course("C05", "Testing with JUnit", CourseStatus.ARCHIVED, "I05"));
        courses.add(new Course("C06", "Advanced Java", CourseStatus.PUBLISHED, "I01"));
        courses.add(new Course("C07", "Microservices", CourseStatus.DRAFT, "I02"));
        courses.add(new Course("C08", "Cloud Native Apps", CourseStatus.PUBLISHED, "I03"));
        courses.add(new Course("C09", "Security for Web", CourseStatus.ARCHIVED, "I04"));
        courses.add(new Course("C10", "DevOps Basics", CourseStatus.PUBLISHED, "I05"));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Course create(Course t) {
        courses.add(t);
        return t;
    }

    @Override
    public Course update(String id, Course t) {
        Course oldCourse = findById(id).orElseThrow(() -> new RuntimeException("Course not found!"));

        if (oldCourse != null) {
            oldCourse.setTitle(t.getTitle());
            oldCourse.setStatus(t.getStatus());
            oldCourse.setInstructorId(t.getInstructorId());
        }

        return oldCourse;
    }

    @Override
    public Course detele(String id) {
        Course oldCourse = findById(id).orElseThrow(() -> new RuntimeException("Course not found!"));

        if (oldCourse != null) {
            courses.remove(oldCourse);
        }

        return oldCourse;
    }

    @Override
    public Optional<Course> findById(String id) {
        return courses.stream().filter(i -> i.getId().equalsIgnoreCase(id)).findFirst();
    }
}

