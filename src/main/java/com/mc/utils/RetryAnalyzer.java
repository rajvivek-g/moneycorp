package com.mc.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{
	Logger logger = LogManager.getLogger(RetryAnalyzer.class);
	
	//make retryCount variable as static. so that the count can be used in BaseTest->@BeforeMethod to report in extent report.
	public static int retryCount=0;
	public static int maxRetryCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		while(retryCount<maxRetryCount) {
			logger.log(Level.ERROR, "Retry Attempt: "+ (retryCount+1) +". Retry execution is in progress as the previous attempt was failed.");
			retryCount++;
			return true;
		}		
		return false;
	}
}