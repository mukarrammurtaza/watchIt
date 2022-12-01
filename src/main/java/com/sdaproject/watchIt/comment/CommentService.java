package com.sdaproject.watchIt.comment;

import com.sdaproject.watchIt.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired private CommentRepository commentRepo;
    public Comment addComment(Comment inputComment) {
        return commentRepo.save(inputComment);
    };
    public String deleteComment(int id) {
        return "Comment successfully deleted";
    }
}
