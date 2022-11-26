package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.report.ReportRepository;
import com.sdaproject.watchIt.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoliceService implements PoliceInterface{

    @Autowired
    private ReportService reportservices;
    @Override
    public Report reviewReport(int id) {
        reportservices.processReport(1);
        return null;
    }
}
