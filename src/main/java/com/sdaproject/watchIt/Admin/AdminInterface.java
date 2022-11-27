package com.sdaproject.watchIt.Admin;

public interface AdminInterface {
    public Admin addAdmin(Admin inputAdminUser);
    public void blockUser(int id);
    public void unBlockUser(int id);

}