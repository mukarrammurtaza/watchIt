package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.user.User;
import com.sdaproject.watchIt.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/police")
public class PoliceController {
    @Autowired PoliceService policeservices;
    @PostMapping()
    public ResponseEntity<Police> registerUser(@RequestBody Police inputPoliceUser) {
        return new ResponseEntity<Police>(policeservices.addPolice(inputPoliceUser), HttpStatus.ACCEPTED);
    }
    @PostMapping("/review")
    private ResponseEntity<Report> reviewReport(int id) {
        Report processedReport = policeservices.reviewReport(id);
        return new ResponseEntity<Report>(processedReport, HttpStatus.ACCEPTED);
    }
}
