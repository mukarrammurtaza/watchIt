package com.sdaproject.watchIt.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminServices;

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
