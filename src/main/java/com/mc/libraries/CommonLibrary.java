package com.mc.libraries;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonLibrary {
	
	WebDriver driver;
	
	public CommonLibrary(WebDriver driver) {
		this.driver = driver;
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String verifyCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void jsScrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void verifyElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}	
}