package com.sdaproject.watchIt.Admin;

public interface AdminServiceInterface {
    public void blockUser(int id);
    public void deletePost(int id);
    public void deleteComment(int id);
    //ReportedUser getReportedUser();
    boolean approvePost(int id);
}
