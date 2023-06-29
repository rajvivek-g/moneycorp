package com.mc.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.mc.base.BaseClass;

public class SuiteListener implements ITestListener, IAnnotationTransformer {
	public static String getAbsolutePathOfCapturedScreenshot;
	
	public void onTestFailure(ITestResult result) {
		String date = new SimpleDateFormat("yyyyMMMdd_HHmmss").format(Calendar.getInstance().getTime());
		
		String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getTestContext().getName()+"_"+ result.getMethod().getMethodName();
		File fileSrc = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.FILE);
		File fileDest = new File(filename+"_"+date+ ".png");

		try {
			FileHandler.copy(fileSrc, fileDest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		getAbsolutePathOfCapturedScreenshot = fileDest.getAbsolutePath();
	}

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
