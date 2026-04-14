package session09.session09.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import session09.session09.model.dto.request.EmployeeCreateDTO;
import session09.session09.model.entity.Department;
import session09.session09.model.entity.Employee;
import session09.session09.repository.DepartmentRepository;
import session09.session09.repository.EmployeeRepository;
import session09.session09.utils.mapper.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public Employee createEmployee(EmployeeCreateDTO dto) {
        Employee entity = EmployeeMapper.mapToEntity(dto);

        Department department = departmentRepository.findById(dto.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException("Phòng ban không tồn tại!"));

        entity.setDepartment(department);

        employeeRepository.save(entity);

        return entity;
    }
}
