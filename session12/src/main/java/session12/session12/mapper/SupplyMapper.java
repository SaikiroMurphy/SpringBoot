package session12.session12.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import session12.session12.model.dto.request.SupplyRequest;
import session12.session12.model.dto.response.SupplyResponse;
import session12.session12.model.entity.Supply;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyMapper {
    Supply toEntity(SupplyRequest request);

    SupplyResponse toResponse(Supply entity);

    void updateEntity(SupplyRequest request, @MappingTarget Supply entity);
}
