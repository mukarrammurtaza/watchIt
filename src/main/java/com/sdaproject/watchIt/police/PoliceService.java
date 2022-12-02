package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
import com.sdaproject.watchIt.report.ReportRepository;
import com.sdaproject.watchIt.report.ReportService;
import com.sdaproject.watchIt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PoliceService implements PoliceInterface{
    @Autowired
    private PoliceRepository policeRepo;
    @Autowired
    private ReportService reportservices;
    @Override
    public Police addPolice(Police inputPoliceUser) {
        inputPoliceUser.setBlocked(false);
        System.out.println(inputPoliceUser);
        Police createdPoliceUser = policeRepo.save(inputPoliceUser);
        return createdPoliceUser;
    }
    @Override
    public Police getDetails(int id) {
        return policeRepo.findById(id).get();
    }
}
