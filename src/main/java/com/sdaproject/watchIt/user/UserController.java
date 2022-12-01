package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userservices;

    @Autowired UserRepository userRepo;
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
            if(userRepo.findByEmail(credentials.getEmail()).get().getAdmin() != null) {
                req.getSession().setAttribute("admin", true);
            }
            return "redirect:/feed";
        }
            else return "redirect:/login";
    }

    @GetMapping("/{userId}")
    public User showDetails(@PathVariable int userId) {
        return userservices.getDetails(userId);
    }

    @PostMapping("/save")
    public String saveUser(User user, @RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Image: " + file.getOriginalFilename());
            user.setProfile_image(file.getInputStream().readAllBytes());
            user.setBlocked(false);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userservices.addUser(user);
            return "redirect:/login";
        } catch (Exception err) {
            System.out.println("Exception: " + err.toString());
            return "redirect:/signup";
        }
    }
}
