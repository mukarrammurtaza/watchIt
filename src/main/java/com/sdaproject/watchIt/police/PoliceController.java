package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/police")
public class PoliceController {
    @Autowired PoliceService policeservices;
    @PostMapping("/review")
    private Report reviewReport(int id) {
        policeservices.reviewReport(id);
        return null;
    }
}
