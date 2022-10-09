package com.orangeHRM.listners;

import java.io.File;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SuiteListener implements ISuiteListener {

	ExtentTest extentTest;
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("=========="+suite.getName() + " execution is started"+"==========");
		extentHtmlReporter = new ExtentHtmlReporter(new File("C:\\CountersignTechnology\\BuisnessManagement\\Reports\\report.html"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	@Override
	public void onFinish(ISuite suite) {
		
		System.out.println("=========="+suite.getName() + " execution is finished"+"==========");
	}

}
