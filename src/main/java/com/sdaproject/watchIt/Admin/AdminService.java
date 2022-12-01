package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class AdminService implements AdminInterface {
    @Autowired private AdminRepository adminRepo;

    @Autowired private UserRepository userRepo;

    @Override
    public Admin addAdmin(Admin inputAdminUser) {
        inputAdminUser.setBlocked(false);
        System.out.println(inputAdminUser);
        Admin createdAdminUser = adminRepo.save(inputAdminUser);
        return createdAdminUser;
    }

    public List<Admin> getAllAdmins() {
        List<Admin> tempList = new ArrayList<Admin>();
        adminRepo.findAll().forEach(user -> {
            tempList.add(user);
        });
        return tempList;
    }
    @Override
    public void blockUser(int id) {
        Optional<User> tempUser = userRepo.findById(id);
        tempUser.ifPresent(x -> {
            x.setBlocked(true);
            userRepo.save(x);
        });
    }
    @Override
    public void unBlockUser(int id) {
        Optional<User> tempUser = userRepo.findById(id);
        tempUser.ifPresent(x -> {
            x.setBlocked(false);
            userRepo.save(x);
        });
    }
}
