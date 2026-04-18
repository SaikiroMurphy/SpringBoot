package session11.session11.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import session11.session11.model.dto.request.DoctorRequest;
import session11.session11.model.dto.response.ApiResponse;
import session11.session11.model.dto.response.PageResponse;
import session11.session11.model.entity.Doctor;
import session11.session11.service.DoctorService;
import session11.session11.utils.enums.ApiResponseStatusEnum;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<ApiResponse<Doctor>> create(@Valid @RequestBody DoctorRequest req) {
        Doctor entity = doctorService.create(req);

        ApiResponse<Doctor> res = new ApiResponse<Doctor>(ApiResponseStatusEnum.SUCCESS, 201, entity, null);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Doctor>> update(@PathVariable Long id, @Valid @RequestBody DoctorRequest req) {
        Doctor entity = doctorService.update(req, id);

        ApiResponse<Doctor> res = new ApiResponse<Doctor>(ApiResponseStatusEnum.SUCCESS, 200, entity, null);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Doctor>>> getAll(@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Doctor> doctors = doctorService.findAll(pageable);


        ApiResponse<List<Doctor>> res = new ApiResponse<>(
                ApiResponseStatusEnum.SUCCESS,
                200,
                doctors.getContent(),
                new PageResponse(
                        doctors.getSize(),
                        doctors.getNumber(),
                        doctors.getTotalElements(),
                        doctors.getTotalPages()
                )
        );

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    
}
