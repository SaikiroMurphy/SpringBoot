package session13.session13.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import session13.session13.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {

}
