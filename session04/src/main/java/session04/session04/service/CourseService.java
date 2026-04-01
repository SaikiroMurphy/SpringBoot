package session04.session04.service;

import org.springframework.stereotype.Service;

import session04.session04.model.dto.CourseCreateRequest;
import session04.session04.model.dto.CourseUpdateRequest;
import session04.session04.model.entity.Course;
import session04.session04.model.entity.Instructor;
import session04.session04.repository.CourseRepository;
import session04.session04.repository.InstructorRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    public CourseService(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public Course createCourse(CourseCreateRequest  req) {
        Instructor foundInstructor = instructorRepository.findById(req.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tồn tại giảng viên có id = " + req.getInstructorId()));

        Course course = new Course();
        course.setStatus(req.getStatus());
        course.setTitle(req.getTitle());
        course.setInstructor(foundInstructor);
        return courseRepository.save(course);
    }
    public Course updateCourse(Long id, CourseUpdateRequest couRequest) {
        Instructor foundInstructor = instructorRepository.findById(couRequest.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Không tồn tại giảng viên có id = " + couRequest.getInstructorId()));

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tồn tại khóa học có id = " + id));
        course.setStatus(couRequest.getStatus());
        course.setTitle(couRequest.getTitle());
        course.setInstructor(foundInstructor);
        return courseRepository.save(course);
    }
}
