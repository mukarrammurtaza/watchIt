package com.sdaproject.watchIt.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired ReportService reportService;
//    @GetMapping("")
//    public String showReportPage() {
//        return "Report";
//    }
    @GetMapping("/addreport")
    public boolean addReport(String text, String location, File media)
    {
        System.out.println("reportAdded");// to test functionality
        return reportService.addReport(text,location,media);
    }
    public Iterable<Report> getNewReports(){
        return reportService.getNewReports();
    }
    public Optional<Report> getUserReports(String id){
        return reportService.getUserReports(id);
    }
    public boolean processReport(String postId){
        return reportService.processReport(postId);//TODO: how exactly is a report considered "processed"
    }
    public List<String> getHotspots(){
        return null;//TODO: ask how this is supposed to work

    }
}

