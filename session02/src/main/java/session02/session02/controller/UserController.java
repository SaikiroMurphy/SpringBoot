package session02.session02.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import session02.session02.model.User;
import session02.session02.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController implements IController<User, Integer>{
    private UserService userService;
    
    @Override
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return ResponseEntity.ok(userService.findByName(name));
        }
        return ResponseEntity.ok(userService.findAll());
    }

    @Override
    public ResponseEntity<User> add(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public ResponseEntity<User> update(Integer id, User t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ResponseEntity<User> delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User findById(@RequestParam Integer id) {
        return userService.findById(id);
    }

}
