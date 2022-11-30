package com.sdaproject.watchIt.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired private ReportRepository reportRepo;


//    public boolean addReport(String text, String location, File media){
//        //TODO: check if a report with exisiting id doesnt already exist
//       // if(reportRepo.findById()) is true return false
//        Report report=new Report();
//    report.setText(text);
//    report.setLocation(location);
//    //TODO: add media to report
//        reportRepo.save(report);
//        return true;
//
//    }

public Report addReport(Report r){
    r.setUserId(007);
    r.setProcessed(false);

    return reportRepo.save(r);

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

    public Optional<Report> processReport(int postId) {
        Optional<Report> report = reportRepo.findById(postId);
        report.ifPresent(x -> {
            x.setProcessed(true);
            reportRepo.save(x);
        });
        return report;
    }

    public List<String> getHotspots(){
        return null;
    }
}
