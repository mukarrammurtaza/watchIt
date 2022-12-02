package com.sdaproject.watchIt.savedComment;

import com.sdaproject.watchIt.comment.Comment;
import com.sdaproject.watchIt.postComment.PostComment;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/savedComment")
public class SavedCommentController {

    @Autowired
    private SavedCommentService savedCommentService;

    @Autowired private SavedCommentRepository SCrepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/new")
    public String createComment(PostComment newComment, HttpServletRequest req) {
        System.out.println("Saving new Comment: " + newComment);
        Optional<User> tempUser = userRepo.findByEmail(req.getSession().getAttribute("email").toString());
        SavedComment newObj = new SavedComment();
        newObj.setText(newComment.getText());
        newObj.setUserId(tempUser.get().getId());
        savedCommentService.addComment(newObj);
        return "redirect:/postComment/" + newComment.getPostId();
    }

    @PostMapping("/delete")
    public String deleteComment(SavedComment thisComment, HttpServletRequest req) {
        SCrepo.deleteById(thisComment.getCommentId());
        return "redirect:/account";
    }
}
