package com.sdaproject.watchIt.report;

import com.sdaproject.watchIt.post.Post;
import com.sdaproject.watchIt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @PostMapping("/save")
    public String addReport(Report newReport) {
        System.out.println(newReport);
        reportService.addReport(newReport);
        return "redirect:/feed";
    }
    @GetMapping("/getallreports")
    public Iterable<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/getapprovedposts")
    public Iterable<Report> getProcessedReports() {
        return reportService.getProcessedReports();
    }

    @GetMapping("/getunapprovedposts")
    public Iterable<Report> getUnProcessedReports() {
        return reportService.getUnProcessedReports();
    }

    @PostMapping("/processReport")
    public String processReport(Report report) {
        System.out.println("Processing Report with id: " + report.getReportId());
        reportService.processReport(report.getReportId());
        return "redirect:/reviewreports";
    }

    public List<String> getHotspots() {
        return null;//TODO: ask how this is supposed to work
    }
}

