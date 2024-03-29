package com.sdaproject.watchIt.report;

import com.sdaproject.watchIt.post.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepo;


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

    public Report addReport(Report r) {
        r.setProcessed(false);
        return reportRepo.save(r);
    }

    @GetMapping("/newReports")
    public Iterable<Report> getNewReports() {
        return null;
    }

    @GetMapping("/allreports")
    public Iterable<Report> getAllReports() {
        return reportRepo.findAll();
    }

    @GetMapping("/processedreports")
    public Iterable<Report> getProcessedReports() {
        Iterable<Report> temp = reportRepo.findAll();
        List<Report> temp2 = new ArrayList<Report>();
        temp.forEach(report -> {
            if (report.isProcessed())//return all Approved Posts
                temp2.add(report);
        });
        return temp2;
    }
    @GetMapping("/unprocessedreports")
    public List<Report> getUnProcessedReports() {
        Iterable<Report> temp = reportRepo.findAll();
        List<Report> temp2 = new ArrayList<Report>();
        temp.forEach(report -> {
            if (!report.isProcessed())//return all Approved Posts
                temp2.add(report);
        });
        return temp2;
    }
    @GetMapping("/userreports")
    public List<Report> getUserReports(int id) {
        try {
            List<Report> temp2 = new ArrayList<Report>();
            reportRepo.findAll().forEach(report ->
            {
                if (id == report.getUserId())//return all Approved Posts
                    temp2.add(report);
            });
            return temp2;
        } catch (NumberFormatException ex) {
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

    public List<String> getHotspots() {
        return null;
    }
}
