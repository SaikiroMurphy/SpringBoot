package session02.session02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import session02.session02.model.User;
import session02.session02.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController implements IController<User, Integer>{
    @Autowired
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
    public ResponseEntity<User> add() {
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
    public ResponseEntity<User> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
