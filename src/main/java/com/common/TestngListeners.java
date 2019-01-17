package com.common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners implements ITestListener {
	
	BaseTest b=new BaseTest();

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
	/*	System.out.println("Passed testcase: "+result.getName());
		b.takeScreeshot("Passed test script");*/
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Failed testcase: "+result.getName());
		b.takeScreeshot("Failed test script");
	
		
	}

	public void onTestSkipped(ITestResult result) {
		//System.out.println("Skipped testcase: "+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	

	public void onTestSuccess(ITestResult result) {
	//System.out.println("Successfully completed testcase: "+result.getName());
		System.out.println("Passed testcase: "+result.getName());
		b.takeScreeshot("Passed test script");
		
	}

}
