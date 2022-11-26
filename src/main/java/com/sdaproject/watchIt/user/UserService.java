package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;

    public User addUser(User newUser) {
        newUser.setBlocked(false);
        User createdUser = userRepo.save(newUser);
        return createdUser;
    }
    public User getDetails(int id) {
       Optional<User> temp = userRepo.findById(id);
       return temp.stream().findFirst().orElse(null);
    }
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

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
