package session04.session04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import session04.session04.model.dto.CourseCreateRequest;
import session04.session04.model.dto.CourseUpdateRequest;
import session04.session04.service.CourseService;
import session04.session04.utils.ApiResponse;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCourse(@RequestBody CourseCreateRequest request) {
        try {
            courseService.createCourse(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.badRequest());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> updateCourse(@PathVariable Long id,
            @RequestBody CourseUpdateRequest request) {
        try {
            courseService.updateCourse(id, request);
            return ResponseEntity.ok(ApiResponse.ok(null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.badRequest());
        }
    }
}
