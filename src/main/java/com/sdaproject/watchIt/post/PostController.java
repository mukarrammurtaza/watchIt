package com.sdaproject.watchIt.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired PostService postservices;
    @GetMapping("/new")
    public List<Post> getPosts() {
        return postservices.getPosts();
    }
    @GetMapping("/simplesearch")
    public List<Post> simpleSearch()
    {
        return postservices.simpleSearch("8 MEN");
    }

    @GetMapping("/advancedsearch")
    public List<Post> advancedSearch()
    {
        return postservices.advancedSearch("8 MEN","fook","Fast", Date.valueOf("2022-11-28"));
    }
}
