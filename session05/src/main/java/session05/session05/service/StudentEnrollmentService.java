package session05.session05.service;

import org.springframework.stereotype.Service;

import session05.session05.model.entity.Course;
import session05.session05.model.entity.EnrollmentId;
import session05.session05.model.entity.Student;
import session05.session05.model.entity.StudentEnrollment;
import session05.session05.repository.CourseRepository;
import session05.session05.repository.StudentEnrollmentRepository;
import session05.session05.repository.StudentRepository;

@Service
public class StudentEnrollmentService {
    private final StudentEnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentEnrollmentService(StudentEnrollmentRepository enrollmentRepository,
            StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public StudentEnrollment enrollStudent(Long studentId, Long courseId) {
        Student foundStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Không có sinh viên có id = " + studentId));

        Course foundCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Không có khóa học có id = " + courseId));

        EnrollmentId enrollmentId = new EnrollmentId(studentId, courseId);
        StudentEnrollment foundEnrollment = enrollmentRepository.findById(enrollmentId).orElse(null);

        if (foundEnrollment != null) {
            throw new RuntimeException("Học sinh đã đăng ký khóa học này rồi!");
        }

        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setId(enrollmentId);
        enrollment.setStudent(foundStudent);
        enrollment.setCourse(foundCourse);
        return enrollmentRepository.save(enrollment);
    }
}
