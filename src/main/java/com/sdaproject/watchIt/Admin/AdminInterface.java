package com.sdaproject.watchIt.Admin;

import com.sdaproject.watchIt.user.User;

public interface AdminInterface {
    public User addAdmin(User inputAdminUser);
    public void blockUser(int id);
    public void unBlockUser(int id);

}