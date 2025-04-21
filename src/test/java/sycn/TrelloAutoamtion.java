package sycn;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.FaceBookSignUpPage;
import com.trello.qspiders.pomrepository.TrelloBoardsPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginToContinuePage;
import com.trello.qspiders.pomrepository.TrelloLogoutPage;

public class TrelloAutoamtion extends BaseClass {
	@Test(invocationCount = 6)
	public void trelloLoginAndLogout() throws Throwable, Throwable {
		webdriverUtils.implicitWait(driver);
		// Click on Login Option in Home page
		String homePageActualTitle = driver.getTitle();
		String homePageExpectedTitle = "Capture, organize, and tackle your to-dos from anywhere | Trello";
		if (webdriverUtils.waitForCompleteTitle(driver, homePageExpectedTitle)) {
			Reporter.log("Pass: The Home Page is Displayed and it is verified upon it's title");
			TrelloHomePage homePage = new TrelloHomePage(driver);
			homePage.getLoginOption().click();
			String loginToContPageExpectedTitle = "Log in to continue - Log in with Atlassian account";
			String loginToContPageActualTitle = driver.getTitle();
			if (webdriverUtils.waitForCompleteTitle(driver, loginToContPageExpectedTitle)) {
				Reporter.log("Pass: The Login To Continue Page is Displayed and it is verified by It's Title");
				// Enter the username
				TrelloLoginToContinuePage loginToCont = new TrelloLoginToContinuePage(driver);
				loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
				// click On Continue button
				loginToCont.getContinueButton().click();
				// Enter the password
				loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
				// click on login button
				loginToCont.getLoginButton().submit();
				// click on Profile Icon
				String boardsPageExpectedTitle = "Boards | Trello";
				String boardsPageActualTitle = driver.getTitle();
				if (webdriverUtils.waitForCompleteTitle(driver, boardsPageExpectedTitle)) {
					Reporter.log("Pass: The Trello Boards Page is Displayed and it's verified Upon it's title");
					TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
					boardsPage.getProfileIconMenu().click();
					// Click on Logout
					boardsPage.getLogoutButton().click();
					// click on Logout
					String logoutPageExpectedTitle = "Log out of your Atlassian account - Log in with Atlassian account";
					String logoutPageActualTitle = driver.getTitle();
					if (webdriverUtils.waitForCompleteTitle(driver, logoutPageExpectedTitle)) {
						Reporter.log("Pass: The Logout Page is Displayed and it's verified and Upon it's title");
						TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
						logoutPage.getLogoutSubmitButton().submit();
						String homePageActualTitleAfterLogout = driver.getTitle();
						String homePageExpecetdTitleAfterLogout = "Capture, organize, and tackle your to-dos from anywhere | Trello";
						if (webdriverUtils.waitForCompleteTitle(driver, homePageExpecetdTitleAfterLogout)) {
							Reporter.log("Pass: Logout is Sucessfull Upon it's verification of Title ");
						} else {
							Reporter.log("Fail: Logout is UnSucessfull Upon it's verification of Title ");
							Reporter.log("homePageActualTitleAfterLogout: " + homePageActualTitleAfterLogout);
							Reporter.log("homePageExpecetdTitleAfterLogout: " + homePageExpecetdTitleAfterLogout);
						}
					} else {
						Reporter.log("Fail: The Logout Page is not Displayed and it's verified and Upon it's title");
						Reporter.log("logoutPageActualTitle: " + logoutPageActualTitle);
						Reporter.log("logoutPageExpectedTitle: " + logoutPageExpectedTitle);
					}

				} else {
					Reporter.log("Fail: The Trello Boards Page is not Displayed and it's verified Upon it's title");
					Reporter.log("boardsPageActualTitle: " + boardsPageActualTitle);
					Reporter.log("boardsPageExpectedTitle: " + boardsPageExpectedTitle);
				}

			} else {
				Reporter.log("Fail: The Login To Continue Page is  not Displayed and it is verified by It's Title");
				Reporter.log("loginToContPageActualTitle: " + loginToContPageActualTitle);
				Reporter.log("loginToContPageExpectedTitle: " + loginToContPageExpectedTitle);
			}

		} else {
			Reporter.log("Fail: The Home Page is not Displayed and it is verified upon it's title");
			Reporter.log("homePageActualTitle: " + homePageActualTitle);
			Reporter.log("homePageExpectedTitle: " + homePageExpectedTitle);
		}

	}

	@Test
	public void verifySignInButtonStatus() {
		webdriverUtils.implicitWait(driver);
		SoftAssert softAssert = new SoftAssert();
		FaceBookSignUpPage signUpPage = new FaceBookSignUpPage(driver);
		softAssert.assertEquals(signUpPage.getSignUpSubmitButton().isEnabled(), true,
				"The SignUp Button is disabled by Default");
		Reporter.log(" The SignUp Button status is verified");
		softAssert.assertAll();
	}

	@Test
	public void verifyDropDownVisibility() {
		webdriverUtils.implicitWait(driver);
		SoftAssert softAssert = new SoftAssert();
		FaceBookSignUpPage signUpPage = new FaceBookSignUpPage(driver);
		// select the Female Radio Button
		signUpPage.getFemaleRadioButton().click();
		// Verify the Female Radio Button Selection after it's select.
		Assert.assertEquals(signUpPage.getFemaleRadioButton().isSelected(), true,
				"Female Radio Button is not selected");
		softAssert.assertEquals(signUpPage.getPreferredPronounListBox().isDisplayed(), false,
				"Preferred Pronoun ListBox is displayed When Female RadioButton is Selected");
		signUpPage.getMaleRadioButton().click();
		// Verify the Female Radio Button Selection after it's select.
		Assert.assertEquals(signUpPage.getMaleRadioButton().isSelected(), true, "Male Radio Button is not selected");
		softAssert.assertEquals(signUpPage.getPreferredPronounListBox().isDisplayed(), false,
				"Preferred Pronoun ListBox is displayed When Male RadioButton is Selected");
		signUpPage.getCustomRadioButton().click();
		// Verify the Female Radio Button Selection after it's select.
		Assert.assertEquals(signUpPage.getCustomRadioButton().isSelected(), true,
				"Custom Radio Button is not selected");
		softAssert.assertEquals(signUpPage.getPreferredPronounListBox().isDisplayed(), true,
				"Preferred Pronoun ListBox is not displayed When Custom RadioButton is Selected");
		Reporter.log("The Preferred Pronoun ListBox is visible in the webpage as per the design");
		softAssert.assertAll();
	}
}
