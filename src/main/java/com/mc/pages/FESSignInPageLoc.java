package com.mc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FESSignInPageLoc {

	WebDriver driver;

	public FESSignInPageLoc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='u-flex u-flex-align-center u-flex-justify-end']//input[@id='nav_search']")
	private WebElement txtIpSearch;
	public WebElement gettxtIpSearch() {
		return txtIpSearch;
	}
	@FindBy(xpath="//div[@class='u-flex u-flex-align-center u-flex-justify-end']//input[@type='submit']")
	private WebElement btnSearchSubmit;
	public WebElement getbtnSearchSubmit() {
		return btnSearchSubmit;
	}
	@FindBy(xpath="//input[@class='chosen-select']")
	private WebElement searchKeyWord;
	public WebElement getsearchKeyWord() {
		return searchKeyWord;
	}
}