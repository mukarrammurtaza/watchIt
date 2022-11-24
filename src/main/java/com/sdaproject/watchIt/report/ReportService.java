package com.sdaproject.watchIt.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired private ReportRepository reportRepo;

    public List<Report> getNewReports(){
        return null;
    }

    public List<Report> getUserReports(String id){
        return null;
    }

    public boolean processReport(String postId){
        return false;
    }

    public List<String> getHotspots(){
        return null;
    }
}
