package com.mc.tests;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mc.libraries.CommonLibrary;
import com.mc.libraries.MCSignInPageLib;
import com.mc.utils.Constants;

public class MCSignInPageTest extends BaseTest{

	Logger logger = LogManager.getLogger(MCSignInPageTest.class);

	@Test
	public void SearchAndVerify() {
		CommonLibrary commonlib = new CommonLibrary(driver);
		MCSignInPageLib mcsigninpglib = new MCSignInPageLib(driver);

		logger.info("1.	Open the following URL: https://www.moneycorp.com/en-gb/  and verify");
		extentTest.info("1.	Open the following URL: https://www.moneycorp.com/en-gb/  and verify");
		String actualPgTitle = commonlib.verifyTitle();
		if (actualPgTitle.equals(Constants.MC_SIGNIN_PAGETITLE)) {
			extentTest.pass("Page title is displayed as expected: "+ actualPgTitle);
		} else {
			extentTest.fail("Page title is incorrect. Expected: " + Constants.MC_SIGNIN_PAGETITLE + " but then Actual: " + actualPgTitle);
		}
		String actualGBURL = commonlib.verifyCurrentPageURL();
		if (actualGBURL.equals(Constants.MC_SIGNINPGLANGANDREGION_GB_URL)) {
			extentTest.pass("Page URL is displayed as expected: "+ actualGBURL);
		} else {
			extentTest.fail("Page URL is incorrect. Expected: " + Constants.MC_SIGNINPGLANGANDREGION_GB_URL + " but then Actual: " + actualGBURL);
		}

		logger.info("2.	Change the language and region from the top right corner to USA (English) and verify");
		extentTest.info("2.	Change the language and region from the top right corner to USA (English) and verify");
		mcsigninpglib.changeRegionAndLanguage();
		String actualUSURL = commonlib.verifyCurrentPageURL();
		if (actualUSURL.equals(Constants.MC_SIGNINPGLANGANDREGION_US_URL)) {
			extentTest.pass("Page URL is displayed as expected: "+ actualUSURL);
		} else {
			extentTest.fail("Page URL is incorrect. Expected: " + Constants.MC_SIGNINPGLANGANDREGION_US_URL + " but then Actual: " + actualUSURL);
		}

		logger.info("3.	Click Find out more for “Foreign exchange solutions” Validate if you have arrived on the page");
		extentTest.info("3.	Click Find out more for “Foreign exchange solutions” Validate if you have arrived on the page");
		mcsigninpglib.navigateToForeignExchangeSolutionsPage();
		String actualFESUSURL = commonlib.verifyCurrentPageURL();
		if (actualFESUSURL.equals(Constants.MC_FES_SIGNINPGLANGANDREGION_US_URL)) {
			extentTest.pass("Navigated to 'Foreign exchange solutions' page. URL is displayed as expected: "+ actualFESUSURL);
		} else {
			extentTest.fail("Page URL is incorrect. Expected: " + Constants.MC_FES_SIGNINPGLANGANDREGION_US_URL + " but then Actual: " + actualFESUSURL);
		}

		logger.info("4.	Search for the word “international payments” using the search box");
		extentTest.info("4.	Search for the word “international payments” using the search box");
		String wordSearch = mcsigninpglib.wordSearch(Constants.MC_FES_WORDSEARCH);
		if (wordSearch.equals(Constants.MC_FES_WORDSEARCH)) {
			extentTest.pass("Searched with " + "\"" + Constants.MC_FES_WORDSEARCH + "\"" + " and retrieved the results for the same.");
		} else {
			extentTest.fail("Searched with incorrect word. Expected: " + Constants.MC_FES_WORDSEARCH + " but then Actual: " + wordSearch);
		}

		logger.info("5.	Validate if you have arrived on the result page");
		extentTest.info("5.	Validate if you have arrived on the result page");
		String actualSearchResultsPgTitle = commonlib.verifyTitle();
		if (actualSearchResultsPgTitle.equals(Constants.MC_SEARCHRESULTSPAGE_PAGETITLE)) {
			extentTest.pass("Search results page displayed for the word " + "\"" + Constants.MC_FES_WORDSEARCH + "\"" + ". Page title is displayed as expected: "+ actualSearchResultsPgTitle);
		} else {
			extentTest.fail("Page title is incorrect. Expected: " + Constants.MC_SEARCHRESULTSPAGE_PAGETITLE + " but then Actual: " + actualSearchResultsPgTitle);
		}

		logger.info("6.	Validate that each article in the list displays a link that starts with https://www.moneycorp.com/en-us/");
		extentTest.info("6.	Validate that each article in the list displays a link that starts with https://www.moneycorp.com/en-us/");
//		String searchResultsPage = mcsigninpglib.searchResultsPage();
//		if (searchResultsPage.split(" : ")[0].equals(searchResultsPage.split(" : ")[2])) {
//			extentTest.info("countSearchResultsInitialTotalNoOfItems: " + searchResultsPage.split(" : ")[0] + " is matching with countSearchResultsFinalTotalNoOfItems: " + searchResultsPage.split(" : ")[2]);	
//		} else {
//			extentTest.warning("countSearchResultsInitialTotalNoOfItems: " + searchResultsPage.split(" : ")[0] + " is not matching with countSearchResultsFinalTotalNoOfItems: " + searchResultsPage.split(" : ")[2]);
//		}
//		if (searchResultsPage.split(" : ")[1].equals(searchResultsPage.split(" : ")[2])) {
//			extentTest.info("countSearchResultsFinalRetrievedViewingItems: " + searchResultsPage.split(" : ")[1] + " is matching with countSearchResultsFinalTotalNoOfItems: " + searchResultsPage.split(" : ")[2]);	
//		} else {
//			extentTest.warning("countSearchResultsFinalRetrievedViewingItems: " + searchResultsPage.split(" : ")[1] + " is not matching with countSearchResultsFinalTotalNoOfItems: " + searchResultsPage.split(" : ")[2]);
//		}
		
		List<WebElement> articleLinks = mcsigninpglib.verifyArticleLink();
		if (articleLinks.size()>0) {
			extentTest.pass("Retrieved results from Search Results page");
			int count=1;
			for (WebElement articleLink: articleLinks) {
				if (articleLink.getAttribute("href").contains(Constants.MC_SIGNINPGLANGANDREGION_US_URL)) {
					extentTest.pass("Link for the article " + count + ". \"" + articleLink.getText() + "\"" + " contains the domain name " + Constants.MC_SIGNINPGLANGANDREGION_US_URL);
				} else {
					extentTest.fail("Link for the article " + count + ". \"" + articleLink.getText() + "\"" +" does not contains the domain name " + Constants.MC_SIGNINPGLANGANDREGION_US_URL);
				}
				count++;
			}
		} else {
			extentTest.fail("No results from the Search Results page");
		}
	}
}