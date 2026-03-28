package session02.session02.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import session02.session02.model.User;
import session02.session02.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService implements IService<User, Integer>{
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User add(User user) {
        return userRepository.add(user);
    }

    @Override
    public User update(Integer id, User t) {
        return userRepository.update(id, t);
    }

    @Override
    public User delete(Integer id) {
        return userRepository.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    
}
