package practicelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L5 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trello.com/");
		// identify the login Option
		// Class value has space - InvalidSelectorException - run - unchecked - selenium
//		WebElement loginOption = driver.findElement(By.className("Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr"));
		WebElement loginOption = driver
				.findElement(By.cssSelector("a[class='Buttonsstyles__Button-sc-1jwidxo-0 kTwZBr']"));
		loginOption.click();
		Thread.sleep(4000);
		//identify the email text field as an active element
		WebElement emailTextfield = driver.switchTo().activeElement();
		emailTextfield.sendKeys("peoplefortiptur@gmail.com");
		//identify continue button
		WebElement cntButton = driver.findElement(By.xpath("//button[contains(.,'Continue')]"));
		cntButton.click();
		Thread.sleep(4000);
		WebElement pwdTextfield = driver.switchTo().activeElement();
		pwdTextfield.sendKeys("Chromepet@123");
		//identify the login button and click
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(.,'Log in') and @id='login-submit']"));
		loginButton.click();
		
	}
}
