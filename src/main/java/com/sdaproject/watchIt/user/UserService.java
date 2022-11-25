package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
@Service
public class UserService implements UserServiceInterface {

    UserServiceInterface usi;
//    @Autowired
//    UserRepository userRepo; //TODO: use??; usi or userRepo

    @Override
    public User getDetails(String id) {
        return usi.getDetails(id);

    }

    @Override
    public void setEmail(String s) {
        usi.setEmail(s);
    }

    @Override
    public void setDOB(String dob) {
        usi.setDOB(dob);
    }

    @Override
    public boolean addPost(String s, File f, String s2, String s3) {
        return false;
    }

    @Override
    public boolean addReport(String s, File f, String s2, String s3) {
        return false;
    }

    @Override
    public boolean checkLogin(int i, String s) {
        return false;
    }


    @Override
    public boolean blockUser(int id) {
        return false;
    }
}
