package session04.session04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import session04.session04.model.dto.StudentEnrollmentRequest;
import session04.session04.service.StudentEnrollmentService;
import session04.session04.utils.ApiResponse;

@RestController
@RequestMapping("/api/enrollments")
public class StudentEnrollmentController {
    private final StudentEnrollmentService enrollmentService;

    public StudentEnrollmentController(StudentEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> enroll(@RequestBody StudentEnrollmentRequest request) {
        try {
            enrollmentService.enrollStudent(request.getStudentId(), request.getCourseId());
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.badRequest());
        }
    }
}
