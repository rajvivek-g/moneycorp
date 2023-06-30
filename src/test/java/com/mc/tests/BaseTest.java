package com.mc.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mc.base.BaseClass;
import com.mc.utils.RetryAnalyzer;
import com.mc.utils.SuiteListener;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static BaseClass bc;
	public static String date;
	public static String extentReportPath;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	
	Logger logger = LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite
	public void initializeExtentRports() {
		date = new SimpleDateFormat("yyyyMMMdd_HHmmss").format(Calendar.getInstance().getTime());
		extentReportPath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"ExtentReport"+"_"+date+".html";
		sparkReporter = new ExtentSparkReporter(extentReportPath);
		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Automation Test Results");		
	}
	
	@BeforeTest
	public void setUp(ITestContext context) {
		bc = new BaseClass();
		prop = bc.init_prop();
		driver = bc.init_driver(prop);
		extentTest = extentReports.createTest(context.getName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method testMethod, ITestResult result) {
		if(RetryAnalyzer.retryCount >= 1) {
			extentTest.log(Status.WARNING,MarkupHelper.createLabel("The <b>" + testMethod.getName() + "</b> test method is failed in it's previous execution. Retry Attempt : "+ RetryAnalyzer.retryCount + " out of " + RetryAnalyzer.maxRetryCount, ExtentColor.AMBER));
		}
	}
	
	@AfterMethod
	public void testCaseStatus(Method testMethod, ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(SuiteListener.getAbsolutePathOfCapturedScreenshot);
			extentTest.fail(testMethod.getName() + " is failed.");
			extentTest.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed - " + result.getName(), ExtentColor.RED));
			extentTest.log(Status.FAIL,MarkupHelper.createLabel("Test Case Failed - " + result.getThrowable(), ExtentColor.RED));
			logger.log(Level.DEBUG, result.getThrowable());
		} else if(result.getStatus() == ITestResult.SKIP) {
			extentTest.skip(testMethod.getName() + " is skipped");
			extentTest.log(Status.SKIP,MarkupHelper.createLabel("Test Case Skipped - " + result.getName(), ExtentColor.ORANGE));
		} else if(result.getStatus() == ITestResult.SUCCESS) {
			extentTest.pass(testMethod.getName() + " is passed");
			extentTest.log(Status.PASS,MarkupHelper.createLabel("Test Case Passed - " + result.getName(), ExtentColor.GREEN));
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void generateExtentReports() throws IOException {
		extentReports.flush();
		Desktop.getDesktop().browse(new File(extentReportPath).toURI());
	}	
}