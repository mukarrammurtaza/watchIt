package com.sdaproject.watchIt.user;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public interface UserServiceInterface {
   // @Autowired private UserRepository userRepo;

    public User getDetails(String id);
       // return null;
    public void setEmail(String s);
    public void setDOB(String dob);
    public boolean addPost(String s, File f, String s2 , String s3);
    public boolean addReport(String s, File f, String s2 , String s3);

    public boolean checkLogin(int i, String s);

    public boolean blockUser(int id);
       // return true;

}
