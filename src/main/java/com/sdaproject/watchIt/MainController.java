package com.sdaproject.watchIt;

import com.sdaproject.watchIt.comment.Comment;
import com.sdaproject.watchIt.police.Police;
import com.sdaproject.watchIt.post.Post;
import com.sdaproject.watchIt.post.PostRepository;
import com.sdaproject.watchIt.post.PostService;
import com.sdaproject.watchIt.postComment.PostComment;
import com.sdaproject.watchIt.postComment.PostCommentRepository;
import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.report.ReportService;
import com.sdaproject.watchIt.savedComment.SavedComment;
import com.sdaproject.watchIt.savedComment.SavedCommentRepository;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import com.sdaproject.watchIt.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ReportService reportService;

    @Autowired
    private SavedCommentRepository SCrepo;

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
    @GetMapping("/reviewreports")
    public String showReviewReport(Model model, HttpServletRequest req)
    {
        if(req.getSession().getAttribute("police") != null){
            model.addAttribute("reports", reportService.getUnProcessedReports());
            return "reviewReports";
        } else return "redirect:/feed";
    }
    @GetMapping("/approveposts")
    public String showApprovePosts(Model model, HttpServletRequest req)
    {
        if(req.getSession().getAttribute("admin") != null){
            model.addAttribute("posts", postService.getUnApprovedPosts());
            model.addAttribute("targetPost", new Post());
            return "approvePosts";
        } else return "redirect:/feed";
    }
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @GetMapping("/signup-police")
    public String showPoliceSignupPage(Model model) {
        model.addAttribute("police", new Police());
        return "signup-police";
    }
    @GetMapping("/report")
    public String showReportPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            if(req.getSession().getAttribute("admin") != null)
                model.addAttribute("admin", true);
            if(req.getSession().getAttribute("police") != null)
                model.addAttribute("police", true);
            model.addAttribute("userId", userRepo.findByEmail(email).get().getId());
            model.addAttribute("newReport", new Report());
            return "Report";
        } else return "redirect:/login";
    }
    @GetMapping("/feed")
    public String showFeedPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            if(req.getSession().getAttribute("admin") != null)
                model.addAttribute("admin", true);
            if(req.getSession().getAttribute("police") != null)
                model.addAttribute("police", true);
            model.addAttribute("userId", userRepo.findByEmail(email).get().getId());
            model.addAttribute("newPost", new Post());
            model.addAttribute("posts", postService.getApprovedPosts());
            model.addAttribute("newComment", new PostComment());
            return "Feed";
        } else return "redirect:/login";
    }

    @GetMapping("/searchpost")
    public String showSearchPostPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("admin") != null)
            model.addAttribute("admin", true);
        if(req.getSession().getAttribute("police") != null)
            model.addAttribute("police", true);
        return "searchpost";
    }

    @GetMapping("/account")
    public String showAccountPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            Optional<User> loggedInUser = userRepo.findByEmail(email);
            if(loggedInUser.get().getProfile_image() != null){
                String userImg = Base64.getEncoder().encodeToString(loggedInUser.get().getProfile_image());
                userImg = "data:image/jpeg;charset=utf-8;base64,".concat(userImg);
                model.addAttribute("userImg", userImg);
            }
            else model.addAttribute("userImg", "https://cdn-icons-png.flaticon.com/512/64/64572.png");
            if(req.getSession().getAttribute("admin") != null)
                model.addAttribute("admin", true);
            if(req.getSession().getAttribute("police") != null)
                model.addAttribute("police", true);
            model.addAttribute("savedComments", SCrepo.findSavedCommentByUserId(loggedInUser.get().getId()));
            model.addAttribute("userDetails", userService.getDetails(loggedInUser.get().getId()));
            model.addAttribute("userPosts", postService.getUserPosts(loggedInUser.get().getId()));
            model.addAttribute("userReports", reportService.getUserReports(loggedInUser.get().getId()));
            return "account";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/hotspot")
    public String showHotSpotPage(Model model, HttpServletRequest req) {
        if(req.getSession().getAttribute("admin") != null)
            model.addAttribute("admin", true);
        if(req.getSession().getAttribute("police") != null)
            model.addAttribute("police", true);
        return "hotspot";
    }
}