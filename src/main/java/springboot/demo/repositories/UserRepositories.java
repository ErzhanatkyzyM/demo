package springboot.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.entities.User;

@Transactional
@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
