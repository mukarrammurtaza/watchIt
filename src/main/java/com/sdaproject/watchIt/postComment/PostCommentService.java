package com.sdaproject.watchIt.postComment;

import com.sdaproject.watchIt.postComment.PostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository PCrepo;

    public void addComment(PostComment newComment) {
        PCrepo.save(newComment);
    }
}
