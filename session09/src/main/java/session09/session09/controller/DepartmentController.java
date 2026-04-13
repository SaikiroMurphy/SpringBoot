package session09.session09.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import session09.session09.model.dto.DepartmentDTO;
import session09.session09.model.dto.response.ApiResponse;
import session09.session09.model.entity.Department;
import session09.session09.service.DepartmentService;
import session09.session09.utils.enums.ApiStatus;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/departments")     
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(@Valid @RequestBody DepartmentDTO req) {
        Department entity = departmentService.createDepartment(req);
        ApiResponse<Department> res = new ApiResponse<>(ApiStatus.SUCCESS, "Thêm phòng ban thành công!", entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
