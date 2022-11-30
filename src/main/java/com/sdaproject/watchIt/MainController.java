package com.sdaproject.watchIt;

import com.sdaproject.watchIt.comment.CommentService;
import com.sdaproject.watchIt.post.Post;
import com.sdaproject.watchIt.post.PostService;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserService;
import com.sdaproject.watchIt.comment.savedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    PostService postservices;
    @Autowired UserService userservices;

    @Autowired savedCommentService scomservices;

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
    public String navigateToLoginPage(Model model) {
        model.addAttribute("email", new String());
        model.addAttribute("password", new String());
        return "Login";
    }
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user",new User());
        return "signup";
    }

    @GetMapping("/report")
    public String showReportPage() {
        return "Report";
    }

    @GetMapping("/feed")
    public String showFeedPage(Model model) {
        List<Post> posts = postservices.getPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("newPost", new Post());
        return "Feed";
    }
    @GetMapping("/account")
    public String showAccountPage(Model model) {
        model.addAttribute("user_info", userservices.getDetails(1));
        model.addAttribute("user_posts", postservices.getUserPosts(1));
        scomservices.getUserComments(1);
        return "Account";
    }

    @GetMapping("/hotspot")
    public String showHotSpotPage() {
        return "hotspot";
    }
}