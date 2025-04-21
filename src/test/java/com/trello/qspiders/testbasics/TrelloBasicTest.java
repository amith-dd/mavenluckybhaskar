package com.trello.qspiders.testbasics;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginToContinuePage;

public class TrelloBasicTest extends BaseClass {
	@Test
	public void trelloHomePageCheck() throws Throwable, Throwable, Throwable {
		webdriverUtils.implicitWait(driver);
		// Step 01: Launch the browser
		// Step 02: Pass the Main URL Of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)),
				true, "Home Page Is not displayed");
		Reporter.log("Home Page Should Be displayed.");
	}

	@Test
	public void trelloLoginPageCheck() throws Throwable, Throwable, Throwable {
		webdriverUtils.implicitWait(driver);
		// Step 01: Launch the browser
		// Step 02: Pass the Main URL Of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)),
				true, "Home Page Is not displayed");
		// Step 03: Click on Login Option
		Reporter.log("Home Page Should Be displayed.");
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)),
				true, "Login To Continue page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)),
				true, "Login To Continue page URL is incorrect");
		Reporter.log("Login To Continue Page Should Be displayed.");
	}
	@Test
	public void trelloBoardPageCheck() throws Throwable, Throwable, Throwable {
		webdriverUtils.implicitWait(driver);
		// Step 01: Launch the browser
		// Step 02: Pass the Main URL Of the app
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 0, 1)),
				true, "Home Page Is not displayed");
		// Step 03: Click on Login Option
		Reporter.log("Home Page Should Be displayed.");
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)),
				true, "Login To Continue page title is incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 2, 1)),
				true, "Login To Continue page URL is incorrect");
		Reporter.log("Login To Continue Page Should Be displayed.");
		//Step 04: Enter the valid registered Email to the username textfield.
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		loginToContPage.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		//Step 05: Click On continue button 
		loginToContPage.getContinueButton().click();
		Assert.assertEquals(webdriverUtils.waitForCompleteTitle(driver, excelUtils.getDataFromCell("trellodata", 1, 1)), true, "Login to Continue page title Is Incorrect");
		Assert.assertEquals(webdriverUtils.waitForPartialUrl(driver, excelUtils.getDataFromCell("trellodata", 0, 3)), true,"Login to Continue Page URL is Incorrect");
		//Step 06: Enter the valid registered password to the password textfield
		loginToContPage.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		//Step 07: Click on fluttered button 
		loginToContPage.getFlutterButton().click();
		//Step 08: Click on Login Button
		loginToContPage.getLoginButton().submit();
	}
	
	

}
