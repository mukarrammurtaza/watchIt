package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/police")
public class PoliceController {
    @Autowired PoliceService policeservices;
    @PostMapping("/save")
    public String saveUser(Police newUser, @RequestParam("file") MultipartFile file) {
        try {
            System.out.println("Image: " + file.getOriginalFilename());
            newUser.setProfile_image(file.getInputStream().readAllBytes());
            newUser.setBlocked(false);
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            policeservices.addPolice(newUser);
            return "redirect:/login";
        } catch (Exception err) {
            System.out.println("Exception: " + err.toString());
            return "redirect:/signup";
        }
    }
    @GetMapping("/{policeId}")
    public User showDetails(@PathVariable int policeId) {
        return policeservices.getDetails(policeId);
    }
}
