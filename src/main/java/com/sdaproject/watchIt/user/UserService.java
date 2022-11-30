package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncode;

    public User addUser(User newUser) {
        newUser.setBlocked(false);
        newUser.setPassword(passwordEncode.encode(newUser.getPassword()));
        User createdUser = userRepo.save(newUser);
        return createdUser;
    }

    public User getDetails(int id) {
       Optional<User> temp = userRepo.findById(Long.valueOf(id));
       if (temp.isPresent()) {
           return temp.get();
       }
       return null;
    }
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

}
