package com.sdaproject.watchIt.postComment;

import com.sdaproject.watchIt.post.PostRepository;
import com.sdaproject.watchIt.savedComment.SavedComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/postComment")
public class PostCommentController {

    @Autowired
    private PostCommentService postCommentService;

    @Autowired
    PostRepository postRepo;

    @Autowired PostCommentRepository PCrepo;

    @PostMapping("/new")
    private String addComment(PostComment newComment) {
        System.out.println("New Comment: " + newComment);
        postCommentService.addComment(newComment);
        return "redirect:/feed";
    }

    @GetMapping("/{postId}")
    public String showPostComments(Model model, HttpServletRequest req, @PathVariable int postId) {
        System.out.println("Displaying comments for post: " + postId);
        if(req.getSession().getAttribute("email") != null) {
            String email = req.getSession().getAttribute("email").toString();
            model.addAttribute("post", postRepo.findById(postId).get());
            model.addAttribute("comments", PCrepo.findPostCommentByPostId(postId));
            model.addAttribute("newComment", new SavedComment());
            return "postComments";
        } else return "redirect:/login";
    }
}
