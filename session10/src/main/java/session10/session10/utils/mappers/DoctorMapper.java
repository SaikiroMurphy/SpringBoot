package session10.session10.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import session10.session10.model.dto.request.DoctorRequest;
import session10.session10.model.entity.Doctor;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper{
    Doctor toEntity(DoctorRequest req);

    Doctor updateEntity(@MappingTarget Doctor entity, DoctorRequest req);
}
