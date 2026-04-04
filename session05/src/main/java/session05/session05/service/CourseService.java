package session05.session05.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import session05.session05.model.dto.request.CourseCreateRequest;
import session05.session05.model.dto.request.CourseUpdateRequest;
import session05.session05.model.dto.response.CourseInstructorResponse;
import session05.session05.model.dto.response.CourseResponse;
import session05.session05.model.dto.response.CourseResponseV2;
import session05.session05.model.dto.response.PageResponse;
import session05.session05.model.entity.Course;
import session05.session05.model.entity.Instructor;
import session05.session05.repository.CourseRepository;
import session05.session05.repository.InstructorRepository;
import session05.session05.utils.CourseStatus;

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

    public PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction) {
        if (page < 0) {
            page = 0;
        }

        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "id";
        }

        Pageable pageable = PageRequest.of(page, size, direction, sortBy);

        Page<CourseResponse> pagedCourses = courseRepository.findAll(pageable).map(c -> {
            return new CourseResponse(
                c.getId(),
                c.getTitle(),
                c.getStatus(), 
                new CourseInstructorResponse(c.getInstructor().getId(),
                    c.getInstructor().getName())
                );
        });

        return new PageResponse<>(
            pagedCourses.getContent(), 
            pagedCourses.getNumber(), 
            pagedCourses.getSize(), 
            pagedCourses.getTotalElements(), 
            pagedCourses.getTotalPages(), 
            pagedCourses.isLast());
    }

    public PageResponse<CourseResponse> getPagedCoursesByStatus(int page, int size, String sortBy, Sort.Direction direction, CourseStatus status) {
        if (page < 0) {
            page = 0;
        }

        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "id";
        }

        Pageable pageable = PageRequest.of(page, size, direction, sortBy);

        Page<CourseResponse> page2 = courseRepository.findAllByStatus(status, pageable).map(c -> {
            return new CourseResponse(
                    c.getId(),
                    c.getTitle(),
                    c.getStatus(),
                    new CourseInstructorResponse(c.getInstructor().getId(),
                            c.getInstructor().getName()));
        });
        
        return new PageResponse<>(
                page2.getContent(),
                page2.getNumber(),
                page2.getSize(),
                page2.getTotalElements(),
                page2.getTotalPages(),
                page2.isLast());
    }

    public PageResponse<CourseResponseV2> getPagedCoursesByStatusV2(int page, int size, String sortBy, Sort.Direction direction, CourseStatus status) {
        if (page < 0) {
            page = 0;
        }

        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "id";
        }

        Pageable pageable = PageRequest.of(page, size, direction, sortBy);

        Page<CourseResponseV2> page2 = courseRepository.findAllByStatusV2(status, pageable).map(c -> {
            return new CourseResponseV2(
                    c.getId(),
                    c.getTitle(),
                    c.getStatus());
        });
        
        return new PageResponse<>(
            page2.getContent(),
            page2.getNumber(),
            page2.getSize(),
            page2.getTotalElements(),
            page2.getTotalPages(),
            page2.isLast()
        );
    }
}
