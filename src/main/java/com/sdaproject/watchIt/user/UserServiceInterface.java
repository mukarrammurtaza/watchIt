package com.sdaproject.watchIt.user;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;



public interface UserServiceInterface {
//    @Autowired
//     UserRepository userRepo;

     User getDetails(String id);
       // return null;
     void setEmail(String s);
     void setDOB(String dob);
     boolean addPost(String s, File f, String s2 , String s3);
     boolean addReport(String s, File f, String s2 , String s3);

     boolean checkLogin(int i, String s);

     boolean blockUser(int id);
       // return true;

}
