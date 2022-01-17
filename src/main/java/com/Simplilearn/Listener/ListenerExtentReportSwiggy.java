package com.Simplilearn.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Simplilearn.Reports.SwiggyExtentReports;

public class ListenerExtentReportSwiggy implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Listener-onTestStart");
		
		SwiggyExtentReports.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Listener-onTestSuccess");
		
		SwiggyExtentReports.logSuccess("Test Passed::"+result.getMethod().getMethodName());
		SwiggyExtentReports.endTest();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Listener-onTestFailure");
		
		//figure out the failed reason
		String errMessage = result.getThrowable().getMessage();
		
		SwiggyExtentReports.logFailures("Error Message:::"+errMessage);

		SwiggyExtentReports.logFailures("Test Failed::"+result.getMethod().getMethodName());
		SwiggyExtentReports.endTest();
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("onTestSkipped:"+methodName);
		
		SwiggyExtentReports.logFailures("Test Failed::"+result.getMethod().getMethodName());
		SwiggyExtentReports.endTest();
	} 

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Listener-onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Listener-onFinish");
		
	}
}
