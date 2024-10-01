package com.myStore.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;


	public void configureReport() {
		ReadConfig readConfig=new ReadConfig();
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSS").format(new Date());
		String reportName="MyStoreTestReport"+timestamp;
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Report//"+reportName+".html");
	//	htmlReporter=new ExtentSparkReporter("C:\\Users\\User\\Downloads\\Screenshot\\ExtentReport"+timestamp+".html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add environment details
		reports.setSystemInfo("Machine", "testpc1");
		reports.setSystemInfo("OS", "window11");
		reports.setSystemInfo("user", "WamiqAzeem");
		reports.setSystemInfo("Browser", readConfig.getBrowser());
		
		//configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Extent Report Demo21");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd,yyyy,hh:mm a'('222')' ");
		
		
	}
	public void onStart(ITestContext Result) {
		configureReport();
		System.out.println(" On start method invoke..");
	}
	public void onFinish(ITestContext Result) {
		System.out.println(" On finish method invoke");
		reports.flush();// flush call to show info on html report
	}
	
	public void onTestSkipped(ITestResult Result) {
		System.out.println(" Name of test method skipped"+ Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("name of skipped test cases are: "+ Result.getName(), ExtentColor.YELLOW));
		
	}
	public void onTestFailure(ITestResult Result) {
		System.out.println(" Name of test method failed"+ Result.getName());
	test=reports.createTest(Result.getName());// create entry in html report
	test.log(Status.FAIL, MarkupHelper.createLabel("name of failed test cases are: "+ Result.getName(), ExtentColor.RED)); // for lok info in html report
	
	String screenShotPath=System.getProperty("user.dir")+"\\Screenshot\\"+Result.getName()+".png";
	
	File ScreenShotFile=new File(screenShotPath);
	
	if (ScreenShotFile.exists()) {
		test.fail("Capture screen shot is below: " +test.addScreenCaptureFromPath(screenShotPath));
	}
	//
	//test.addScreenCaptureFromPath(null)
	}
	//ye method har ek test method pe call hoga.
	public void onTestStart(ITestResult Result) {
		System.out.println(" Name of test method start"+ Result.getName());
		
	}
	public void onTestSuccess(ITestResult Result) {
		System.out.println(" Name of test method success"+ Result.getName());
		test=reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("name of passed test cases are: "+ Result.getName(), ExtentColor.GREEN));
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
	}
}
