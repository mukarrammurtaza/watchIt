package com.sdaproject.watchIt.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostCommentService {
    @Autowired
    private CommentRepository commentRepo;

    public PostComment addPostComment(PostComment inputPostComment, int postId) {
        LocalDate date = LocalDate.now();
        inputPostComment.setPostId(postId);
        return commentRepo.save(inputPostComment);
    }
}
