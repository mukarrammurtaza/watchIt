package com.sdaproject.watchIt.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired PostService postservices;

    @GetMapping("/savepost")
    public String savePost(@RequestParam("{userid}")Post post){
        postservices.save(post);
        return "redirect:/home";
    }

    @GetMapping("/newpost")
    public String showPostForm(Model model){
        model.addAttribute("post",new Post());
        return "Post_Form";
    }
    @GetMapping("/getallposts")
    public List<Post> getPosts() {
        return postservices.getAllPosts();
    }
    @GetMapping("/getapprovedposts")
    public List<Post> getApprovedPosts() {
        return postservices.getApprovedPosts();
    }
    @GetMapping("/getunapprovedposts")
    public List<Post> getUnApprovedPosts() {
        return postservices.getUnApprovedPosts();
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
