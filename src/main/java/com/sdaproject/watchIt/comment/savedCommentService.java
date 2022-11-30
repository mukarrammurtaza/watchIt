package com.sdaproject.watchIt.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class savedCommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Autowired savedCommentRepository scomRepo;

    public List<SavedComment> getUserComments(int id) {
        List<SavedComment> tempList = new ArrayList<SavedComment>();
        scomRepo.findAll().forEach(comment -> {
            System.out.println(comment);
        });
        return tempList;
    }

    public SavedComment addSavedComment(SavedComment inputSavedComment, int userId) {
        LocalDate date = LocalDate.now();
        inputSavedComment.setDate(java.sql.Date.valueOf(date));
        inputSavedComment.setUserId(userId);
        return commentRepo.save(inputSavedComment);
    }
}
