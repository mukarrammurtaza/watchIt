package com.sdaproject.watchIt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {

   /* @GetMapping()
    public String showHomePage() {
        return "home";
    }
    @GetMapping("/home")
    public String navigateToHomePage() {
        return "home";
    }*/
    @GetMapping()
    public String showLoginPage() {
        System.out.println("Login function called");
        return "Login";
    }
    @GetMapping("/signin")
    public String navigateToLoginPage() {
        return "Login";
    }
    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }
    @GetMapping("/report")
    public String showReportPage() {
        return "Report";
    }
    @GetMapping("/feed")
    public String showFeedPage() {
        return "Feed";
    }

    @GetMapping("/searchpost")
    public String showSearchPostPage() {return "searchpost";}
    @GetMapping("/account")
    public String showAccountPage() {
        return "Account";
    }
    @GetMapping("/hotspot")
    public String showHotSpotPage() {
        return "hotspot";
    }

}