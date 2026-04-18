package session11.session11.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import session11.session11.model.dto.request.DoctorRequest;
import session11.session11.model.entity.Doctor;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoctorMapper{
    Doctor toEntity(DoctorRequest req);

    Doctor updateEntity(@MappingTarget Doctor entity, DoctorRequest req);
}
