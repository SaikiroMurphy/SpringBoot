package session09.session09.utils.mapper;

import session09.session09.model.dto.DepartmentDTO;
import session09.session09.model.entity.Department;

public class DepartmentMapper {
    public static DepartmentDTO mapToDto(Department entity) {
        DepartmentDTO dto = new DepartmentDTO();

        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());

        return dto;
    }

    public static Department mapToEntity(DepartmentDTO dto) {
        Department entity = new Department();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        return entity;
    }
}
