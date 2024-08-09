package controllers;

import exceptions.ResourceNotFoundException;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sevices.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user){
        return userService.findByUsername(user.getUsername())
                .filter(u -> userService.getPasswordEncoder().matches(user.getPassword(), u.getPassword()))
                .orElseThrow(() -> new ResourceNotFoundException("Invalid usernam or password"));
    }

}
