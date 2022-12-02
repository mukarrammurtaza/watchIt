package com.sdaproject.watchIt.post;

import com.sdaproject.watchIt.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;

    public void deletePost(int id) {
        Optional<Post> post = postRepo.findById(id);
        post.ifPresent(x -> {
            //x.setProcessed(true);
            postRepo.delete(x);
        });
    }

    public boolean validatePost(int id) {
        Optional<Post> post = postRepo.findById(id);
        post.ifPresent(x -> {
            //x.setProcessed(true);
            x.setApproved(true);
            postRepo.save(x);
        });
        return false;
    }

    public List<Post> getReqApproval() {
        return null;
    }

    public void save(Post post) {
        post.setApproved(false);
        post.setCategory("Social Awareness");
        LocalDate D = LocalDate.now();
        post.setDate(java.sql.Date.valueOf(D));
        postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        Iterable<Post> temp = postRepo.findAll();
        List<Post> temp2 = new ArrayList<Post>();
        temp.forEach(post -> {
            temp2.add(post);
        });
        return temp2;
    }

    public List<Post> getUserPosts(int id) {
        Iterable<Post> temp = postRepo.findAll();
        List<Post> temp2 = new ArrayList<Post>();
        temp.forEach(post -> {
            if (post.getUserId() == id) temp2.add(post);
        });
        return temp2;
    }

    public List<Post> getApprovedPosts() {
        Iterable<Post> temp = postRepo.findAllByOrderByDateDesc();
        List<Post> temp2 = new ArrayList<Post>();
        temp.forEach(post -> {
            if (post.isApproved())//returnin all Approved Posts
                temp2.add(post);
        });
        return temp2;
    }

    public List<Post> getUnApprovedPosts() {
        Iterable<Post> temp = postRepo.findAll();
        List<Post> temp2 = new ArrayList<Post>();
        temp.forEach(post -> {
            if (!post.isApproved())//returnin all Approved Posts
                temp2.add(post);
        });
        return temp2;
    }

    public List<Post> getPendingPosts() {//same as unApproved posts
        Iterable<Post> temp = postRepo.findAll();
        List<Post> temp2 = new ArrayList<Post>();
        temp.forEach(post -> {
            if (!post.isApproved())//return all UnApproved Posts
                temp2.add(post);
        });
        return temp2;
    }

    public List<Post> simpleSearch(String keyword) {
        List<Post> currentPosts = getApprovedPosts();
        List<Post> searchResult = new ArrayList<Post>();
        for (int i = 0; i < currentPosts.size(); i++) {
            String postTxt = currentPosts.get(i).getText().toLowerCase();
            if (postTxt.indexOf(keyword.toLowerCase()) != -1) {
                searchResult.add(currentPosts.get(i));
            }
        }
        return searchResult;
    }

    public List<Post> advancedSearch(String keyword, String category, String location, Date date) {
        List<Post> currentPosts = getApprovedPosts();
        List<Post> searchResult = new ArrayList<Post>();
        int resultPriority[] = new int[currentPosts.size()];
        int j = 0;
        for (int i = 0; i < currentPosts.size(); i++) {
            String postTxt = currentPosts.get(i).getText().toLowerCase();
            String postCat = currentPosts.get(i).getCategory().toLowerCase();
            String postLoc = currentPosts.get(i).getLocation().toLowerCase();
            Date postDate = currentPosts.get(i).getDate();
            if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postCat.indexOf(category.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1 && postDate == date) {                                                               // all 4: key, cat, loc, date  --- best result

                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 1;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postCat.indexOf(category.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1) {                                                               // key, cat, loc
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 2;
                j++;
            } else if (postCat.indexOf(category.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1 && postDate == date) {                                                               // cat, loc, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 2;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postCat.indexOf(category.toLowerCase()) != -1 && postDate == date) {                                                               // key, cat, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 2;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1 && postDate == date) {                                                                // key, loc, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 2;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postCat.indexOf(category.toLowerCase()) != -1) {                                                                // key, cat
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1) {                                                               // key, loc
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 && postDate == date) {                                                                // key, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postCat.indexOf(category.toLowerCase()) != -1 && postLoc.indexOf(location.toLowerCase()) != -1) {                                                                // cat, loc
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postCat.indexOf(category.toLowerCase()) != -1 && postDate == date) {                                                               // cat, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postLoc.indexOf(location.toLowerCase()) != -1 && postDate == date) {                                                               // loc, date
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 3;
                j++;
            } else if (postTxt.indexOf(keyword.toLowerCase()) != -1 || postCat.indexOf(category.toLowerCase()) != -1 || postLoc.indexOf(location.toLowerCase()) != -1 || postDate == date) {                                                               // any one
                searchResult.add(currentPosts.get(i));
                resultPriority[j] = 4;
                j++;
            }
        }
        // sorting according to search priority
        int minIndex = 0, temp = 0;
        Post temp2;
        for (int i = 0; i < j - 1; i++) {
            minIndex = i;
            for (int k = i + 1; k < j; k++)
                if (resultPriority[k] < resultPriority[minIndex]) minIndex = k;
            temp = resultPriority[i];
            temp2 = searchResult.get(i);

            resultPriority[i] = resultPriority[minIndex];
            searchResult.set(i, searchResult.get(minIndex));

            resultPriority[minIndex] = temp;
            searchResult.set(minIndex, temp2);
        }
        return searchResult;
    }
}
