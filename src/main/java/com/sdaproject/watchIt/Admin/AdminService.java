package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService implements AdminInterface {
    @Autowired private UserRepository userRepo;
    @Override
    public void blockUser(int id) {
        Optional<User> tempUser = userRepo.findById(id);
        tempUser.ifPresent(x -> {
            x.setBlocked(true);
            userRepo.save(x);
        });
    }
    public void unBlockUser(int id) {
        Optional<User> tempUser = userRepo.findById(id);
        tempUser.ifPresent(x -> {
            x.setBlocked(false);
            userRepo.save(x);
        });
    }
}
