package trelloscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.trello.qspiders.pomrepository.TrelloHomePage;

public class TrelloLogin {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/");
		// identify the login option
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		
		

	}
}
