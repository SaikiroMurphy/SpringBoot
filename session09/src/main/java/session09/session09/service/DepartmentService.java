package session09.session09.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import session09.session09.model.dto.DepartmentDTO;
import session09.session09.model.entity.Department;
import session09.session09.repository.DepartmentRepository;
import session09.session09.utils.mapper.DepartmentMapper;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentDTO dto) {
        Department entity = DepartmentMapper.mapToEntity(dto);
        departmentRepository.save(entity);
        return entity;
    }
}
