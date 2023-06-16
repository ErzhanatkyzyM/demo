package springboot.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.demo.entities.User;
import springboot.demo.services.impl.UserServiceImpl;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping(path = "/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        User addedUser = userService.createUser(user);
        return ResponseEntity.ok("User created: " + addedUser);
    }


    @RequestMapping(path = "/deleteUser", method=RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@RequestParam(name = "id") Long id){
        User searchUser = userService.getUser(id);
        if (searchUser!=null){
            userService.deleteUser(searchUser);
            return ResponseEntity.ok("User successful deleted ");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the user");
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestParam(name = "id") Long id,
                                             @RequestParam(name = "full_name") String fullName,
                                             @RequestParam(name = "email") String email,
                                             @RequestParam(name = "password") String password){
        User user= userService.getUser(id);
        if (user!=null){
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            userService.updateUser(user);
            return ResponseEntity.ok("User update successfully ");
        }else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while update the user");
        }
    }
}
