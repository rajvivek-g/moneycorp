package com.mc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageLoc {
	WebDriver driver;

	public SearchPageLoc(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@aria-label='Show more results']")
	private WebElement lnkShowMoreResults;
	public WebElement getlnkShowMoreResults() {
		return lnkShowMoreResults;
	}
	@FindBy(xpath="//div[@class='pagination bottom']/p/span[2]")
	private WebElement countSearchResultsInitialTotalNoOfItems;
	public WebElement getcountSearchResultsInitialTotalNoOfItems() {
		return countSearchResultsInitialTotalNoOfItems;
	}
	@FindBy(xpath="//div[@class='pagination bottom']/p/span[1]")
	private WebElement countSearchResultsViewingItems;
	public WebElement getcountSearchResultsViewingItems() {
		return countSearchResultsViewingItems;
	}
	@FindBy(xpath="//div[@class='pagination bottom']/p/span[2]")
	private WebElement countSearchResultsTotalNoOfItems;
	public WebElement getcountSearchResultsTotalNoOfItems() {
		return countSearchResultsTotalNoOfItems;
	}
	@FindBy(xpath="//div[@class='results']//a")
	private List<WebElement> lstResultsLink;
	public List<WebElement> getlstResultsLink() {
		return lstResultsLink;
	}
}