package session15.session15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import session15.session15.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
