package session11.session11.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import session11.session11.model.dto.request.PatientRequest;
import session11.session11.model.entity.Patient;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PatientMapper {
    Patient toEntity(PatientRequest req);

    Patient updateEntity(@MappingTarget Patient entity, PatientRequest req);
}
