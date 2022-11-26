package com.sdaproject.watchIt.user;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonNumberFormatVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservices;

    @GetMapping
    public Iterable<User> showUsers() {
        return userservices.getAllUsers();
    }

    @GetMapping("/details")
    public User showDetails(@RequestParam("id") int id) {
        return userservices.getDetails(id);
    }

    @PostMapping()
    public ResponseEntity<User> registerUser(@RequestBody User inputUser) {
        return new ResponseEntity<User>(userservices.addUser(inputUser), HttpStatus.ACCEPTED);
    }
}
