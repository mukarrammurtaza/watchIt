package com.sdaproject.watchIt.savedComment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavedCommentService {

    @Autowired
    private SavedCommentRepository SCrepo;

    public void addComment(SavedComment newComment) {
        SCrepo.save(newComment);
    }
}
