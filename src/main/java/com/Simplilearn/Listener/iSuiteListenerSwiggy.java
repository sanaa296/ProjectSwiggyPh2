package com.Simplilearn.Listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.Simplilearn.Reports.SwiggyExtentReports;

public class iSuiteListenerSwiggy implements ISuiteListener{

    @Override
    public void onStart(ISuite suite) {
        // TODO Auto-generated method stub
        System.out.println("Suite started...");
        SwiggyExtentReports.initReport("target/SwiggyextentReport.html");
    }
    @Override
    public void onFinish(ISuite suite) {
        // TODO Auto-generated method stub
        System.out.println("Suite ended...");
        SwiggyExtentReports.closeReport();
    }
    

}
