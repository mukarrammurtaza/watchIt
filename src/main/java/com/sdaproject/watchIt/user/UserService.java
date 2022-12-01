package com.sdaproject.watchIt.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public boolean authenticate(User credentials) {
        Optional<User> found =  userRepo.findByEmail(credentials.getEmail());
        if(found.isPresent()){
            System.out.println("User found: "+ found.get());
            User userFound = found.get();
            if(userFound.getPassword().equals(credentials.getPassword()))
                return true;
            else return false;
        } else {
            return false;
        }
    }
    public User addUser(User newUser) {
        newUser.setBlocked(false);
        User createdUser = userRepo.save(newUser);
        return createdUser;
    }
    public User getDetails(int id) {
       Optional<User> temp = userRepo.findById(id);
       if (temp.isPresent()) {
           return temp.get();
       }
       return null;
    }
    public Iterable<User> getAllUsers() {
        return userRepo.findAll();
    }

}
