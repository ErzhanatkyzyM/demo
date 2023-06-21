package springboot.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.demo.entities.User;
import springboot.demo.exception.UserNotFoundException;
import springboot.demo.repositories.UserRepositories;
import springboot.demo.services.UserService;

import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    @Override
    public User getUserByEmail(String s) throws UserNotFoundException {
        User searchUser = userRepositories.findByEmail(s);
        if (searchUser!= null){
            return searchUser;
        }

        throw new UserNotFoundException("user email not found!");
    }

    @Override
    public User getUser(Long id) {
        User user = userRepositories.findById(id).orElseThrow(() -> new UserNotFoundException("Course not found: " + id));
        return user;
    }

    @Override
    public User createUser(User user) {
        User checkUser= userRepositories.findByEmail(user.getEmail());
        if (checkUser == null){
            return userRepositories.save(user);
        }else {
            return checkUser;
        }
    }

    @Override
    public User saveUser(User user) {
        return userRepositories.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepositories.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User not found: " + user.getId()));
        userRepositories.delete(user);
    }

    @Override
    public User updateUser(User user) {
        userRepositories.findById(user.getId()).orElseThrow(() -> new UserNotFoundException("User not found: " + user.getId()));
        return userRepositories.save(user);
    }

    @Autowired
    public UserServiceImpl(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }


    public Optional<User> findByUsername(String username) {
        Optional<User> user = userRepositories.findByUsername(username);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
