package springboot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.demo.entities.User;

import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
    User findByEmail(String email);

    Optional<User> findByUsername(String username);
}
