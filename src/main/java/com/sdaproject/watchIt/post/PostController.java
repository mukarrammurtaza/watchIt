package com.sdaproject.watchIt.post;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired PostService postservices;
    public boolean showSearchDiv=false;
    public boolean showsearchresult=false;

    @PostMapping("/save")
    public String addPost(Post newPost){
        System.out.println(newPost);
        postservices.save(newPost);
        return "redirect:/feed";
    }

    @PostMapping("/approve")
    public String approvePost(Post post) {
        postservices.validatePost(post.getPostId());
        return "redirect:/approveposts";
    }
    @PostMapping("/delete")
    public String deletePost(Post post) {
        postservices.deletePost(post.getPostId());
        if(post.getUserId() == 1) {
            return "redirect:/account";
        }
        return "redirect:/approveposts";
    }
    @GetMapping("/simplesearch")
    public List<Post> simpleSearch(Post p)
    {
        return postservices.simpleSearch(p.getText());
    }


    @GetMapping("/advancedsearch")
    public List<Post> advancedSearch(Post p)
    {
        return postservices.advancedSearch(p.getText(),p.getCategory(),p.getLocation(), p.getDate());
    }
    @PostMapping("/searchwrapper")
    public String searchWrapper( Post post, Model model)
    {
        List<Post>searchResult;
        if(!post.getText().isEmpty()&&(!post.getCategory().isEmpty()||!post.getLocation().isEmpty()|| post.getDate()!=null))
            searchResult = advancedSearch(post);
        else
            searchResult = simpleSearch(post);

        if(!searchResult.isEmpty())
            showsearchresult=true;
        else
            showsearchresult=false;
        System.out.println("Search Results: " + searchResult);
        model.addAttribute("searchresult", searchResult);
        model.addAttribute("post",post);
        model.addAttribute("showsearchresult",showsearchresult);
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
