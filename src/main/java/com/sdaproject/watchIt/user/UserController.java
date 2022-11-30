package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @Autowired
    private UserService userservices;

//    @GetMapping
//    public Iterable<User> showUsers() {
//        return userservices.getAllUsers();
//    }
//
    @GetMapping("/user/{userId}")
    public User showDetails(@PathVariable int userId) {
        return userservices.getDetails(userId);
    }

    @PostMapping("/create")
    public String registerUser(User inputUser) {
        System.out.println(inputUser);
        try {
            User createdUser = userservices.addUser(inputUser);
            System.out.println("User Registered");
            return "redirect:/signin";
        } catch (Exception e) {
            System.out.println(e);
//            return "redirect:signup";
        }
        return "redirect:/signup";
    }
}
