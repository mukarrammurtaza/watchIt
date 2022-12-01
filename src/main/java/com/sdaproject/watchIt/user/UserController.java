package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservices;

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
            userservices.addUser(user);
            return "redirect:/feed";
        } catch (Exception err) {
            return "redirect:/signup";
        }
    }
}
