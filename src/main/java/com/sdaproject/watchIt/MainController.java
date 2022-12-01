package com.sdaproject.watchIt;

import com.sdaproject.watchIt.post.Post;
import com.sdaproject.watchIt.post.PostService;
import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.report.ReportService;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import com.sdaproject.watchIt.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostService postService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ReportService reportService;

    @GetMapping()
    public String showLoginPage() {
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String navigateToLoginPage(Model model) {
        System.out.println("Login function called");
        model.addAttribute("user", new User());
        return "login";
    }
    @GetMapping("/logout")
    public String logoutUser(HttpServletRequest req) {
        System.out.println("Logout Function Called");
        req.getSession().invalidate();
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @GetMapping("/report")
    public String showReportPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            model.addAttribute("userId", userRepo.findByEmail(email).get().getId());
            model.addAttribute("newReport", new Report());
            return "Report";
        } else return "redirect:/login";
    }
    @GetMapping("/feed")
    public String showFeedPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            model.addAttribute("userId", userRepo.findByEmail(email).get().getId());
            model.addAttribute("newPost", new Post());
            model.addAttribute("posts", postService.getApprovedPosts());
            return "Feed";
        } else return "redirect:/login";
    }

    @GetMapping("/searchpost")
    public String showSearchPostPage() {return "searchpost";}

    @GetMapping("/account")
    public String showAccountPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            Optional<User> loggedInUser = userRepo.findByEmail(email);
            String userImg = Base64.getEncoder().encodeToString(loggedInUser.get().getProfile_image());
            userImg = "data:image/jpeg;charset=utf-8;base64,".concat(userImg);
            model.addAttribute("userImg", userImg);
            model.addAttribute("userDetails", userService.getDetails(loggedInUser.get().getId()));
            model.addAttribute("userPosts", postService.getUserPosts(loggedInUser.get().getId()));
            model.addAttribute("userReports", reportService.getUserReports(loggedInUser.get().getId()));
            return "account";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/hotspot")
    public String showHotSpotPage() {
        return "hotspot";
    }
}