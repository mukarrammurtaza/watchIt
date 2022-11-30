package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AdminService implements AdminInterface {
    @Autowired private AdminRepository adminRepo;
    @Override
    public Admin addAdmin(Admin inputAdminUser) {
        inputAdminUser.setBlocked(false);
        System.out.println(inputAdminUser);
        Admin createdAdminUser = adminRepo.save(inputAdminUser);
        return createdAdminUser;
    }
    @Override
    public void blockUser(int id) {
        Optional<User> tempUser = adminRepo.findById(Long.valueOf(id));
        tempUser.ifPresent(x -> {
            x.setBlocked(true);
            adminRepo.save(x);
        });
    }
    public void unBlockUser(int id) {
        Optional<User> tempUser = adminRepo.findById(Long.valueOf(id));
        tempUser.ifPresent(x -> {
            x.setBlocked(false);
            adminRepo.save(x);
        });
    }
}
