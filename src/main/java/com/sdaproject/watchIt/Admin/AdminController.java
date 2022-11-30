package com.sdaproject.watchIt.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
//@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminServices;

    @PostMapping
    public Admin addAdmin(@RequestBody Admin inputAdmin) {
        return adminServices.addAdmin(inputAdmin);
    }
    @PutMapping("/block/{userId}")
    public String blockUser(@PathVariable int userId) {
        adminServices.blockUser(userId);
        return "User successfully blocked";
    }
    @PutMapping("/unblock/{userId}")
    public String unBlockUser(@PathVariable int userId) {
        adminServices.unBlockUser(userId);
        return "User successfully unBlocked";
    }
}
