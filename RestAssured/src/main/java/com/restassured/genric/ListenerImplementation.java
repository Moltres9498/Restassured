//package com.restassured.genric;
//
//import java.util.Random;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//public class ListenerImplementation extends BaseClass implements ITestListener {
//
//	ExtentReports report;
//	ExtentTest test;
//
//	public void onTestStart(ITestResult result) {
//		test=report.createTest(result.getName());
//	}
//
//	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, result.getMethod().getMethodName());
//		test.log(Status.PASS, result.getThrowable());
//	}
//
//	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, result.getMethod().getMethodName());
//		test.log(Status.FAIL, result.getThrowable());
//		String Methodname = result.getMethod().getMethodName();
//		WebActionUtility wutil;
//		try {
//			wutil = new WebActionUtility();
//			wutil.takescreenshot(driver, Methodname);
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void onTestSkipped(ITestResult result) {
//		test.log(Status.SKIP, result.getMethod().getMethodName());
//		test.log(Status.SKIP, result.getThrowable());
//	}
//
//	public void onStart(ITestContext context) {
//		Random ran=new Random();
//		@SuppressWarnings("unused")
//		int rannum=ran.nextInt(1000);
//		ExtentSparkReporter spark=new ExtentSparkReporter("Extentreport/report.html");
//		spark.config().setTheme(Theme.DARK);
//		spark.config().setDocumentTitle("Extent report");
//		spark.config().setReportName("HRM");
//		report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("platform", "windows10");
//		report.setSystemInfo("Executed by", "Madhusudhan N");
//		report.setSystemInfo("recieved by","sanjay");
//	}
//
//	public void onFinish(ITestContext context) {
//		report.flush();
//	}
//}