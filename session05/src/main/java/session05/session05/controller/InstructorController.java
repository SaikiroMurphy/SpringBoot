package session05.session05.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import session05.session05.model.dto.request.InstructorCreateRequest;
import session05.session05.service.InstructorService;
import session05.session05.utils.ApiResponse;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createInstructor(@RequestBody InstructorCreateRequest request) {
        try {
            instructorService.createInstructor(request);
            return ResponseEntity.created(null).build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
