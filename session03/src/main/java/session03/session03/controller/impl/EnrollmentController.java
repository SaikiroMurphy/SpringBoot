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
import session03.session03.model.Enrollment;
import session03.session03.service.impl.EnrollmentService;
import session03.session03.utils.ApiResponse;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController implements IController<Enrollment>{
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Override
    @GetMapping
    public ApiResponse<List<Enrollment>> findAll() {
        List<Enrollment> foundEnrollments = enrollmentService.findAll();

        if(foundEnrollments != null && !foundEnrollments.isEmpty()) {
            return ApiResponse.ok(foundEnrollments);
        }
        return ApiResponse.notFound();
    }

    @Override
    @PostMapping
    public ApiResponse<Enrollment> create(@RequestBody Enrollment t) {
        Enrollment createdEnrollment = enrollmentService.create(t);

        if (createdEnrollment != null) {
            return ApiResponse.created(createdEnrollment);
        }
        return ApiResponse.badRequest();
    }

    @Override
    @PutMapping("/{id}")
    public ApiResponse<Enrollment> update(@PathVariable String id, @RequestBody Enrollment t) {
        Enrollment updatedEnrollment = enrollmentService.update(id, t);
        if (updatedEnrollment != null) {
            return ApiResponse.ok(updatedEnrollment);
        }
        return ApiResponse.notFound();
    }

    @Override
    @GetMapping("/{id}")
    public ApiResponse<Enrollment> findById(@PathVariable String id) {
        Enrollment foundEnrollment = enrollmentService.findById(id);

        if (foundEnrollment != null) {
            return ApiResponse.ok(foundEnrollment);
        }
        return ApiResponse.notFound();
    }

    @Override
    @DeleteMapping("/{id}")
    public ApiResponse<Enrollment> delete(@PathVariable String id) {
        Enrollment deletedEnrollment = enrollmentService.detele(id);
        if (deletedEnrollment != null) {
            return ApiResponse.ok(deletedEnrollment);
        }
        return ApiResponse.notFound();
    }

}
