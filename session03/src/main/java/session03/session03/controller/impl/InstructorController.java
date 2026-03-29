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
import session03.session03.model.Instructor;
import session03.session03.service.impl.InstructorService;
import session03.session03.utils.ApiResponse;

@RequestMapping("/api/instructors")
@RestController
public class InstructorController implements IController<Instructor>{
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Override
    @GetMapping
    public ApiResponse<List<Instructor>> findAll() {
        List<Instructor> foundInstructors = instructorService.findAll();

        if(!foundInstructors.isEmpty()) {
            return ApiResponse.ok(foundInstructors);
        }
        return ApiResponse.notFound();
    }

    @Override
    @PostMapping
    public ApiResponse<Instructor> create(@RequestBody Instructor t) {
        Instructor createdInstructor = instructorService.create(t);

        if (createdInstructor != null) {
            return ApiResponse.created(createdInstructor);
        }
        return ApiResponse.badRequest();
    }

    @Override
    @PutMapping("/{id}")
    public ApiResponse<Instructor> update(@PathVariable String id, @RequestBody Instructor t) {
        try {
            return ApiResponse.ok(instructorService.update(id, t));

        } catch (RuntimeException e) {
            return ApiResponse.notFound();
        }

    }

    @Override
    @GetMapping("/{id}")
    public ApiResponse<Instructor> findById(@PathVariable String id) {
        try {
            return ApiResponse.ok(instructorService.findById(id));
            
        } catch (RuntimeException e) {
            return ApiResponse.notFound();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ApiResponse<Instructor> delete(@PathVariable String id) {
        try {
            return ApiResponse.ok(instructorService.detele(id));
            
        } catch (RuntimeException e) {
            return ApiResponse.notFound();
        }
    }

}
