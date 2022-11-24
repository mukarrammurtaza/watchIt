package com.sdaproject.watchIt.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired private PostRepository postRepo;

    public boolean validatePost(String id){
        return false;
    }

    public List<Post> getReqApproval(){
        return null;
    }

    public boolean approvePost(String id){
        return true;
    }

    public List<Post> search(String category, String location, Date date){
        return null;
    }
}
