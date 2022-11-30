package com.sdaproject.watchIt.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class savedCommentService {

    @Autowired
    private CommentRepository commentRepo;

    public SavedComment addSavedComment(SavedComment inputSavedComment, int userId) {
        LocalDate date = LocalDate.now();
        inputSavedComment.setDate(java.sql.Date.valueOf(date));
        inputSavedComment.setUserId(userId);
        return commentRepo.save(inputSavedComment);
    }
}
