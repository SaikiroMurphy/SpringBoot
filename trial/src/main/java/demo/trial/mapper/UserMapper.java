package session11.session11.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import session11.session11.model.dto.request.UserRequest;
import session11.session11.model.dto.response.UserResponse;
import session11.session11.model.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toEntity (UserRequest req);
    UserResponse toResponse(User entity);
    User updateEntity(@MappingTarget User entity, UserRequest req);
}
