package session05.session05.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import session05.session05.model.dto.request.CourseCreateRequest;
import session05.session05.model.dto.request.CourseUpdateRequest;
import session05.session05.model.dto.response.CourseResponse;
import session05.session05.model.dto.response.CourseResponseV2;
import session05.session05.model.dto.response.PageResponse;
import session05.session05.model.entity.Course;
import session05.session05.service.CourseService;
import session05.session05.utils.ApiResponse;
import session05.session05.utils.CourseStatus;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Course>> createCourse(@RequestBody CourseCreateRequest request) {
        try {
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> updateCourse(@RequestParam Long id,
            @RequestBody CourseUpdateRequest request) {
        try {
            courseService.updateCourse(id, request);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // @GetMapping
    // public ResponseEntity<ApiResponse<PageResponse<CourseResponse>>> getPagedCourses(
    //     @RequestParam(defaultValue = "0") int page,
    //     @RequestParam(defaultValue = "10") int size,
    //     @RequestParam(required = false) String sortBy,
    //     @RequestParam(defaultValue = "DESC") Sort.Direction direction,
    //     @RequestParam(defaultValue = "PUBLISHED") CourseStatus status
    // ) {
    //     // PageResponse<CourseResponse> courses = courseService.getPagedCourses(page, size, sortBy, direction);
    //     PageResponse<CourseResponse> courses = courseService.getPagedCoursesByStatus(page, size, sortBy, direction, status);
    //     return ResponseEntity.ok(new ApiResponse<>(true, "Get Courses by Page success!", courses));
    // }
    
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CourseResponseV2>>> getPagedCourses(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String sortBy,
        @RequestParam(defaultValue = "DESC") Sort.Direction direction,
        @RequestParam(defaultValue = "PUBLISHED") CourseStatus status
    ) {
        // PageResponse<CourseResponse> courses = courseService.getPagedCourses(page, size, sortBy, direction);
        PageResponse<CourseResponseV2> courses = courseService.getPagedCoursesByStatusV2(page, size, sortBy, direction, status);
        return ResponseEntity.ok(new ApiResponse<>(true, "Get Courses by Page success!", courses));
    }
    
}
