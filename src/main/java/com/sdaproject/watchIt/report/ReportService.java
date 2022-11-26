package com.sdaproject.watchIt.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired private ReportRepository reportRepo;


    public boolean addReport(String text, String location, File media){
        //TODO: check if a report with exisiting id doesnt already exist
       // if(reportRepo.findById()) is true return false
        Report report=new Report();
    report.setText(text);
    report.setLocation(location);
    //TODO: add media to report
        reportRepo.save(report);
        return true;

    }




    @GetMapping("/newReports")
    public Iterable<Report> getNewReports(){
        return reportRepo.findAll();
    }
    @GetMapping("/userReports")
    public Optional<Report> getUserReports(String id){
        try{
            int number = Integer.parseInt(id);
           return reportRepo.findById(number);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public boolean processReport(String postId){

        if(reportRepo.findById(Integer.valueOf(postId)).isPresent()){
            return false;//assuming we remove a report after it has been catered

        }
        return true;
    }

    public List<String> getHotspots(){
        return null;
    }
}
