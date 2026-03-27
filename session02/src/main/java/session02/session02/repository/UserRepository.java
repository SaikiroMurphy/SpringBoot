package session02.session02.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import session02.session02.model.User;
import session02.session02.utils.Role;

@Repository
public class UserRepository implements IRepository<User, Integer>{
    private static List<User> users;

    public UserRepository() {
        users = new ArrayList<>();

        users.add(new User(1, "admin", "admin@gmail.com", Role.ADMIN));
        users.add(new User(2, "customer1", "user1@gmail.com", Role.CUSTOMER));
        users.add(new User(3, "customer2", "user2@gmail.com", Role.CUSTOMER));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    public List<User> findByName(String name) {
        return users.stream().filter(u -> u.getUsername().toLowerCase().contains(name.toLowerCase())).toList();
    }

    @Override
    public User add() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public User update(Integer id, User t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public User delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
