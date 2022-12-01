package com.sdaproject.watchIt.post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.swing.text.html.HTML;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired PostService postservices;
    public boolean showSearchDiv=false;
    public boolean showsearchresult=false;
    @GetMapping("/savepost")
    public String savePost(@RequestParam("id") Post post){
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
        return postservices.getPendingPosts();
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
    @GetMapping("/searchwrapper")
    public String searchWrapper(Model model)
    {
        showsearchresult=!showsearchresult;
        List<Post>searchResult;
        if(showSearchDiv)
            searchResult = advancedSearch();
        else
            searchResult = simpleSearch();
        boolean searchempty= simpleSearch().isEmpty();
        model.addAttribute("showsearchresult",showsearchresult);
        model.addAttribute("searchempty", searchempty);
        model.addAttribute("searchresult", searchResult);

        return "searchpost";
    }
    @GetMapping("/showsearchdiv")
    public String showsearchdiv(Model model)
    {
        showSearchDiv= !showSearchDiv;
        model.addAttribute("showSearchDiv",showSearchDiv);
        return "searchpost";
    }
}
