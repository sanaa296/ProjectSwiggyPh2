package com.Simplilearn.Reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SwiggyExtentReports {


    static ExtentReports report;
    static ExtentTest test;
    
    public static void initReport(String pathOfReport) {
    	System.out.println("ExtentReportinit");
        report = new ExtentReports(pathOfReport);
    }
    
    public static void closeReport() {
        report.flush();
    }

	public static void startTest(String nameOfTest) {
		test = report.startTest(nameOfTest);
	}

	public static void endTest() {
		report.endTest(test);
	}
    public static void logSuccess(String message) {
        test.log(LogStatus.PASS,message);
    }
    public static void logFailures(String message) {
        test.log(LogStatus.FAIL,message);
    }
    public static void logTimeout(String message) {
        test.log(LogStatus.WARNING,message);
    }
    public static void logError(String message) {
        test.log(LogStatus.ERROR,message);
    }
    
}
