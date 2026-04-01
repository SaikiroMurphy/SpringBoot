package session04.session04.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import session04.session04.model.dto.InstructorCreateRequest;
import session04.session04.service.InstructorService;
import session04.session04.utils.ApiResponse;

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
            return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created(null));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(ApiResponse.badRequest());
        }
    }
}
