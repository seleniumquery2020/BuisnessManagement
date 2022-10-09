package com.orangeHRM.listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=========="+result.getName() + " execution is started"+"==========");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=========="+result.getName() + " execution is Passed"+"==========");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("=========="+result.getName() + " execution is Failed"+"==========");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("=========="+result.getName() + " method is failed"+"==========");
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
