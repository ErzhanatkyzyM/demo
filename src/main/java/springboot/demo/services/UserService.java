package springboot.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import springboot.demo.entities.User;
import springboot.demo.exception.UserNotFoundException;

public interface UserService extends UserDetailsService {

    User getUserByEmail(String email) throws UserNotFoundException;

    User createUser(User user);

    User saveUser(User user);

    void deleteUser(User user);

    User updateUser(User user);

}
