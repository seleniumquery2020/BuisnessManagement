package com.orangeHRM.listners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends SuiteListener implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		extentTest =  extentReports.createTest(result.getName()+" execution");
		extentTest.info("=========="+result.getName() + " execution is started"+"==========");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.info("=========="+result.getName() + " execution is Passed"+"==========");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.fail(result.getName() + " execution is Failed");
		try {
			extentTest.addScreenCaptureFromPath("C:\\CountersignTechnology\\BuisnessManagement\\Screenshot\\Screenshot_09102022_124801.png");
		} catch (IOException e) {
			
		}
		extentTest.error("=========="+result.getName() + " execution is Failed"+"==========");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.info("=========="+result.getName() + " method is failed"+"==========");
	}
	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("=========="+context.getName() + " is started"+"==========");
	}
	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("=========="+context.getName() + " execution is Finished"+"==========");

	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}
	
	
 
     
    
}
