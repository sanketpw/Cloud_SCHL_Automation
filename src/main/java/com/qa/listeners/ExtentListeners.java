package com.qa.listeners;

import java.io.IOException;
import java.util.Date;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;



public class ExtentListeners implements ITestListener, ISuiteListener {

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager
			.createInstance(".\\reports\\" + fileName);

	public static ExtentTest test;
	
	
	
	
	
	

	public void onTestStart(ITestResult result) {

		test = extent
				.createTest(result.getTestClass().getName() + "\n" + "     @TestCase : " + result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<l>" + " TEST CASE  :  " +  methodName.toUpperCase()  +   "  - PASSED " + "</l>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}

	public void onTestFailure(ITestResult result) {
		

		test.fail(result.getThrowable().getMessage());
		try {
			ExtentManager.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodName=result.getMethod().getMethodName();
		String logText="<l>" + " TEST CASE  :  " +  methodName.toUpperCase()  +  " -  FAILED " + "</l>";		
	
	

		try {
			test.fail("<l><font color=red>" + "Screenshot of Failure" + "</font></l><br>",MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName)
					.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
		
		

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<l>" + " Test Case  : " + methodName + " - SKIPPED" + "</l>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}



}
