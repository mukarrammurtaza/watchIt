package com.sdaproject.watchIt.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired ReportService reportService;
//    @GetMapping("")
//    public String showReportPage() {
//        return "Report";
//    }
//    @GetMapping("/addreport")
//    public boolean addReport(String text, String location, File media)
//    {
//        System.out.println("reportAdded");// to test functionality
//        return reportService.addReport(text,location,media);
//    }
    @PostMapping
public ResponseEntity<Report> addReport(@RequestBody Report newReport) {
    return new ResponseEntity<Report>(reportService.addReport(newReport), HttpStatus.ACCEPTED);
}
    public Iterable<Report> getNewReports(){
        return reportService.getNewReports();
    }
    public Optional<Report> getUserReports(String id){
        return reportService.getUserReports(id);
    }
    public Optional<Report> processReport(@RequestBody Map<Integer, Object> report){
        return reportService.processReport(Integer.valueOf(((Integer) report.get("id"))));

    }
    public List<String> getHotspots(){
        return null;//TODO: ask how this is supposed to work

    }
}

