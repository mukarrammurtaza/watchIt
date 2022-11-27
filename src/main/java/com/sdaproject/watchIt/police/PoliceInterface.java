package com.sdaproject.watchIt.police;

import com.sdaproject.watchIt.report.Report;
public interface PoliceInterface {
    public Police addPolice(Police inputPoliceUser);
    public Report reviewReport(int id);
}
