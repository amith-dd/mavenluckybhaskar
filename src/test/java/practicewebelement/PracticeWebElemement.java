package practicewebelement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.TrelloBoardsPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginToContinuePage;

public class PracticeWebElemement extends BaseClass {
	@Test
	public void usageOfClickAndisSelected() throws Throwable {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		// -ve scenario - Before Click
		if (loginToContPage.getRememberMeCheckBox().isSelected()) {
			System.out.println("-ve - functional - Fail - true - selected");
		} else {
			System.out.println("-ve - functional - Pass - false - not selected");
		}
		loginToContPage.getRememberMeCheckBox().click();
		// +ve Funactionality Testing after click
		if (loginToContPage.getRememberMeCheckBox().isSelected()) {
			System.out.println("+ve - functional - pass - true - selected");
		} else {
			System.out.println("+ve - functional - fail - false - not selected");
		}
	}

	@Test
	public void usageOfSendKeys() throws Throwable {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		loginToContPage.getEmailTextField().clear();
		loginToContPage.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		Thread.sleep(3000);
		loginToContPage.getEmailTextField().clear();
		System.out.println(loginToContPage.getEmailTextField().getAttribute("placeholder"));
		System.out.println(loginToContPage.getEmailTextField().getAttribute("type"));
	}

	@Test
	public void colorOfContButton() throws Throwable {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(3000);
		TrelloLoginToContinuePage loginToContPage = new TrelloLoginToContinuePage(driver);
		String color = loginToContPage.getContinueButton().getCssValue("background-color");
		System.out.println("background-color: " + color);
		String fontType = loginToContPage.getContinueButton().getCssValue("font-family");
		String fontSize = loginToContPage.getContinueButton().getCssValue("font-size");
		String fontWeight = loginToContPage.getContinueButton().getCssValue("font-weight");
		System.out.println("fontType: " + fontType);
		System.out.println("fontSize: " + fontSize);
		System.out.println("fontWeight: " + fontWeight);
	}

	@Test
	public void usageOfIsDisplayed() {
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		int count = allDropDowns.size();
		System.out.println("count: " + count);
		for (WebElement dropdown : allDropDowns) {
			String dropDownName = dropdown.getDomAttribute("aria-label");
			if (dropdown.isDisplayed()) {
				System.out.println("visible: " + dropDownName);
			} else {
				System.out.println("Invisible: " + dropDownName);
			}
		}
	}
	@Test
	public void usageOfIsEnabled() throws Throwable, Throwable {
		Thread.sleep(2000);
		//click on Login option in trellohomeopage
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(2000);
		//enter the user name in trellologin to cont page\
		TrelloLoginToContinuePage loginToCont = new TrelloLoginToContinuePage(driver);
		loginToCont.getEmailTextField().sendKeys(javaUtils.readDataFromPropertyFile("username"));
		Thread.sleep(2000);
		//click on continue  button in trellologin to cont page
		loginToCont.getContinueButton().click();
		Thread.sleep(2000);
		//enter the passowrd in trellologin to cont page
		loginToCont.getPasswordTextField().sendKeys(javaUtils.readDataFromPropertyFile("password"));
		Thread.sleep(2000);
		//click on login  button in trellologin to cont page
		loginToCont.getLoginButton().submit();
		Thread.sleep(2000);
		//click on create new board in trello boards page
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		Thread.sleep(2000);
		boardsPage.getCreateNewBoardOption().click();
		Thread.sleep(2000);
		boardsPage.getBoardTitleTextfield().sendKeys("a");
		Thread.sleep(2000);
		//check create button is enabled or not in trello boards page
		if (boardsPage.getCreateBoardButton().isEnabled()) {
			System.out.println("The Create Board Button is enabled");
		}else {
			System.out.println("The Create Board Button is Disabled");
		}
		Thread.sleep(2000);
	}
	@Test
	public void usageOfGetSize() throws Throwable{
		Thread.sleep(2000);
		//click on Login option in trellohomeopage
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		Thread.sleep(2000);
		driver.navigate().refresh();
		//enter the user name in trellologin to cont page\
		TrelloLoginToContinuePage loginToCont = new TrelloLoginToContinuePage(driver);
		Thread.sleep(2000);
		Dimension emailTextfieldSize = loginToCont.getEmailTextField().getSize();
		System.out.println("emailTextfieldSize: " + emailTextfieldSize);
		System.out.println("emailTextField Width is: " + emailTextfieldSize.getWidth());
		System.out.println("emailTextField height is: " + emailTextfieldSize.getHeight());
		Point emailTextfieldLocation = loginToCont.getEmailTextField().getLocation();
		System.out.println(emailTextfieldLocation);
		
	}
	
	

}
