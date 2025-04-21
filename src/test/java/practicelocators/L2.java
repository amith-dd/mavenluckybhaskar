package practicelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L2 {
	public static void main(String[] args) {
		// Instantiate the browser specific class
		WebDriver driver = new ChromeDriver();
		// maximize the browser window
		driver.manage().window().maximize();
		// pass the main of the app
		driver.get("https://shop-global.malaicha.com/login");
		// identify the username text field
		WebElement emailTextfield = driver.findElement(By.name("username"));
		emailTextfield.sendKeys("213456789@gnmail.com");
		//identtify the pwd text field
		WebElement pwdTextfield = driver.findElement(By.name("pin"));
		pwdTextfield.sendKeys("1234567890");
	}
}
