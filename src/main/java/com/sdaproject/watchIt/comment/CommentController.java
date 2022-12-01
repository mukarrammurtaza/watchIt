package com.sdaproject.watchIt.comment;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private CommentService commentservices;

    private savedCommentService savedcommentservices;

    private PostCommentService postcommentservices;
}
