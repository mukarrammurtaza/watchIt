package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;

    public User getDetails(String id) {
        return null;
    }

    public boolean blockUser(String id) {
        return true;
    }
}
