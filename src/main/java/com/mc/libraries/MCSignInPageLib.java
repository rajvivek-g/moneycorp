package com.mc.libraries;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mc.pages.FESSignInPageLoc;
import com.mc.pages.MCSignInPageLoc;
import com.mc.pages.SearchPageLoc;


public class MCSignInPageLib extends CommonLibrary{

	WebDriver driver;
	MCSignInPageLoc mcsigninpgloc;
	FESSignInPageLoc fessigninpgloc;
	SearchPageLoc searchpgloc;


	public MCSignInPageLib(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		mcsigninpgloc = new MCSignInPageLoc(driver);
		fessigninpgloc = new FESSignInPageLoc(driver);
		searchpgloc = new SearchPageLoc(driver);
	}

	public void changeRegionAndLanguage() {
		mcsigninpgloc.getbtnLangDropdown().click();
		mcsigninpgloc.getlnkRegionAndLanguageSelector().click();
	}
	
	public void navigateToForeignExchangeSolutionsPage() {
		if (mcsigninpgloc.getbtnCloseForCookiesAlertDialogBox().isDisplayed()) {
			mcsigninpgloc.getbtnCloseForCookiesAlertDialogBox().click();
		}
		jsScrollIntoView(mcsigninpgloc.getlnkfindOutMoreForeignExchangeSolutions());
		verifyElementToBeClickable(mcsigninpgloc.getlnkfindOutMoreForeignExchangeSolutions());
		if (mcsigninpgloc.getlnkfindOutMoreForeignExchangeSolutions().isDisplayed()) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("document.getElementsByClassName('c-btn c-btn--secondary ignoreScrollEvents')[1].click();");
		}
		
	}
	
	public String wordSearch(String word) {
		verifyElementToBeClickable(fessigninpgloc.gettxtIpSearch());
		fessigninpgloc.gettxtIpSearch().sendKeys(word);
		verifyElementToBeClickable(fessigninpgloc.getbtnSearchSubmit());
		fessigninpgloc.getbtnSearchSubmit().click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		String searchKey = fessigninpgloc.getsearchKeyWord().getAttribute("value");
		return searchKey;
	}
	
	public String searchResultsPage() {
		verifyElementToBeClickable(searchpgloc.getlnkShowMoreResults());
		String countSearchResultsInitialTotalNoOfItems = searchpgloc.getcountSearchResultsInitialTotalNoOfItems().getText();
		
		String countSearchResultsFinalRetrievedViewingItems = null;
		String countSearchResultsFinalTotalNoOfItems = null;
		
		while (searchpgloc.getlnkShowMoreResults().isDisplayed()) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("document.getElementsByClassName('show-more show-more-search')[0].click();");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		}
		if (!searchpgloc.getlnkShowMoreResults().isDisplayed()) {
			countSearchResultsFinalRetrievedViewingItems = searchpgloc.getcountSearchResultsViewingItems().getText();
			countSearchResultsFinalTotalNoOfItems = searchpgloc.getcountSearchResultsTotalNoOfItems().getText();
		}
		return countSearchResultsInitialTotalNoOfItems +" : "+ countSearchResultsFinalRetrievedViewingItems +" : "+ countSearchResultsFinalTotalNoOfItems;		
	}
	
	public List<WebElement> verifyArticleLink() {
		List<WebElement> getlstResultsLink = searchpgloc.getlstResultsLink();
//		System.out.println(getlstResultsLink.size());
//		getlstResultsLink.forEach(e->{
//			System.out.println(e.getAttribute("href"));
//		});
		return getlstResultsLink;
	}
}