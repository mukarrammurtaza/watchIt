package com.sdaproject.watchIt.report;

import org.springframework.web.bind.annotation.GetMapping;

public class ReportController {
    @GetMapping("")
    public String showReportPage() {
        return "Report";
    }

}

