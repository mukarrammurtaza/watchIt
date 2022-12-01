package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservices;

//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping
    public Iterable<User> showUsers() {
        return userservices.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User showDetails(@PathVariable int userId) {
        return userservices.getDetails(userId);
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        try {
            user.setBlocked(false);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userservices.addUser(user);
            return "redirect:/feed";
        } catch (Exception err) {
            return "redirect:/signup";
        }
    }
}
