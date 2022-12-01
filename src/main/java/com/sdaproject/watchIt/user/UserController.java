package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    @PostMapping("/authenticate")
    public String authenticate(User credentials, HttpServletRequest req) {
        System.out.println(credentials);
        if (userservices.authenticate(credentials)) {
            System.out.println("Validated User");
            req.getSession().setAttribute("email", credentials.getEmail());
            return "redirect:/feed";
        }
            else return "redirect:/login";
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
            return "redirect:/login";
        } catch (Exception err) {
            return "redirect:/signup";
        }
    }
}
