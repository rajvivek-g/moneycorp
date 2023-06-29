package com.mc.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MCSignInPageLoc {
	
	WebDriver driver;

	public MCSignInPageLoc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='language-dropdown-flag']")
	private WebElement btnLangDropdown;
	public WebElement getbtnLangDropdown() {
		return btnLangDropdown;
	}
	@FindBy(xpath="//a[@aria-label='USA English']")
	private WebElement lnkRegionAndLanguageSelector;
	public WebElement getlnkRegionAndLanguageSelector() {
		return lnkRegionAndLanguageSelector;
	}
	@FindBy(xpath="//h3[text()='Foreign exchange solutions']")
	private WebElement headerForeignExchangeSolutions;
	public WebElement getheaderForeignExchangeSolutions() {
		return headerForeignExchangeSolutions;
	}
	@FindBy(xpath="//div[@id='onetrust-close-btn-container']/button")
	private WebElement btnCloseForCookiesAlertDialogBox;
	public WebElement getbtnCloseForCookiesAlertDialogBox() {
		return btnCloseForCookiesAlertDialogBox;
	}
	@FindBy(xpath="//h3[text()='Foreign exchange solutions']/parent::div/a[normalize-space(@aria-label)='Find out more']")
	private WebElement lnkfindOutMoreForeignExchangeSolutions;
	public WebElement getlnkfindOutMoreForeignExchangeSolutions() {
		return lnkfindOutMoreForeignExchangeSolutions;
	}
}