package session03.session03.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import session03.session03.model.Course;
import session03.session03.repository.impl.CourseRepository;
import session03.session03.service.IService;

@Service
public class CourseService implements IService<Course>{
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course t) {
        return courseRepository.create(t);
    }

    @Override
    public Course update(String id, Course t) {
        return courseRepository.update(id, t);
    }

    @Override
    public Course detele(String id) {
        return courseRepository.detele(id);
    }

    @Override
    public Course findById(String id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found!"));
    }

}
