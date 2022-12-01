package com.sdaproject.watchIt.report;

import com.sdaproject.watchIt.post.Post;
import com.sdaproject.watchIt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired ReportService reportService;
    @GetMapping("/new")
    public String showNewForm(Model model){
        model.addAttribute("report",new Report());
        return "report";
    }
    @PostMapping
public ResponseEntity<Report> addReport(@RequestBody Report newReport) {
    return new ResponseEntity<Report>(reportService.addReport(newReport), HttpStatus.ACCEPTED);
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
    @GetMapping("/getuserposts")
    public Iterable<Report> getUserReports(@RequestParam("id") String id){
        return reportService.getUserReports(id);
    }
    @GetMapping("/processreport")
    public Optional<Report> processReport(@RequestBody Map<Integer, Object> report){
        return reportService.processReport(Integer.valueOf(((Integer) report.get("id"))));

    }
    public List<String> getHotspots(){
        return null;//TODO: ask how this is supposed to work

    }
}

