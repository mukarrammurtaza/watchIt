package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminServices;

    @PostMapping
    public User addAdmin(@RequestBody User inputAdmin) {
        return adminServices.addAdmin(inputAdmin);
    }
    @PutMapping("/block")
    public String blockUser(@RequestBody Map<String, Object> input) {
        adminServices.blockUser(Integer.valueOf(((String) input.get("id"))));
        return "User successfully blocked";
    }

    @PutMapping("/unblock")
    public String unBlockUser(@RequestBody Map<String, Object> input) {
        adminServices.unBlockUser(Integer.valueOf(((String) input.get("id"))));
        return "User successfully unBlocked";
    }
}
