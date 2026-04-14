package session09.session09.utils.mapper;

import session09.session09.model.dto.request.EmployeeCreateDTO;
import session09.session09.model.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEntity(EmployeeCreateDTO dto) {
        Employee entity = new Employee();

        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setSalary(dto.getSalary());

        return entity;
    }
}
