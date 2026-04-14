package session09.session09.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import session09.session09.model.dto.request.EmployeeCreateDTO;
import session09.session09.model.dto.response.ApiResponse;
import session09.session09.model.entity.Employee;
import session09.session09.service.EmployeeService;
import session09.session09.utils.enums.ApiStatus;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreateDTO req) {
        Employee entity = employeeService.createEmployee(req);

        ApiResponse<Employee> res = new ApiResponse<>(ApiStatus.SUCCESS, "Thêm nhân viên thành công!", entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
