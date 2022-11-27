package com.sdaproject.watchIt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

    @GetMapping()
    public String showHomePage() {
        return "home";
    }
    @GetMapping("/home")
    public String navigateToHomePage() {
        return "home";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "Login";
    }
    @GetMapping("/report")
    public String showReporPage() {
        return "Report";
    }
    @GetMapping("/feed")
    public String showFeedPage() {
        return "Feed";
    }
    @GetMapping("/account")
    public String showAccountPage() {
        return "Account";
    }

}