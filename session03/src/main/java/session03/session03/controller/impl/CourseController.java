package session03.session03.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import session03.session03.controller.IController;
import session03.session03.model.Course;
import session03.session03.service.impl.CourseService;
import session03.session03.utils.ApiResponse;

@RequestMapping("/api")
@RestController
public class CourseController implements IController<Course>{
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    @GetMapping
    public ApiResponse<List<Course>> findAll() {
        List<Course> foundCourses = courseService.findAll();

        if(foundCourses != null && !foundCourses.isEmpty()) {
            return ApiResponse.ok(foundCourses);
        }
        return ApiResponse.notFound();
    }

    @Override
    @PostMapping
    public ApiResponse<Course> create(@RequestBody Course t) {
        Course createdCourse = courseService.create(t);
        if (createdCourse != null) {
            return ApiResponse.created(createdCourse);
        }
        return ApiResponse.badRequest();
    }

    @Override
    @PutMapping("/{id}")
    public ApiResponse<Course> update(@PathVariable String id, @RequestBody Course t) {
        Course updatedCourse = courseService.update(id, t);
        if (updatedCourse != null) {
            return ApiResponse.ok(updatedCourse);
        }
        return ApiResponse.notFound();
    }

    @Override
    @GetMapping("/{id}")
    public ApiResponse<Course> findById(String id) {
        Course foundCourse = courseService.findById(id);

        if (foundCourse != null) {
            return ApiResponse.ok(foundCourse);
        }
        return ApiResponse.notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ApiResponse<Course> delete(String id) {
        Course deletedCourse = courseService.detele(id);
        if (deletedCourse != null) {
            return ApiResponse.ok(deletedCourse);
        }
        return ApiResponse.notFound();
    }

}
