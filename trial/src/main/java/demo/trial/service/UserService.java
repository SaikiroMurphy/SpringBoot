package session11.session11.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import session11.session11.mapper.UserMapper;
import session11.session11.model.dto.request.UserRequest;
import session11.session11.model.dto.response.UserResponse;
import session11.session11.model.entity.User;
import session11.session11.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService implements IService<UserRequest, Long, UserResponse>{
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(UserMapper.INSTANCE::toResponse).toList();
        
    }

    @Override
    public Page<UserResponse> getAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserMapper.INSTANCE::toResponse);
    }

    @Override
    public UserResponse create(UserRequest req) {
        User entity = UserMapper.INSTANCE.toEntity(req);
        userRepository.save(entity);
        return UserMapper.INSTANCE.toResponse(entity);
    }

    @Override
    public UserResponse update(UserRequest req, Long id) {
        User oldEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại người dùng có ID phù hợp!"));

        User newEntity = UserMapper.INSTANCE.updateEntity(oldEntity, req);
        userRepository.save(newEntity);

        return UserMapper.INSTANCE.toResponse(newEntity);
    }

    @Override
    public UserResponse deleteById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại người dùng có ID phù hợp!"));

        userRepository.delete(entity);

        return UserMapper.INSTANCE.toResponse(entity);

    }

    @Override
    public UserResponse findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tồn tại người dùng có ID phù hợp!"));

        return UserMapper.INSTANCE.toResponse(entity);
    }

}
