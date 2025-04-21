package practicelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L1 {
	public static void main(String[] args) {
		// Instantiate the browser specific class
		WebDriver driver = new ChromeDriver();
		// Maximize the browser
		driver.manage().window().maximize();
		// pass the main URL of the app
		driver.get("https://www.facebook.com/");
		// identify the email text field
		WebElement emailTextfield = driver.findElement(By.id("email"));
		emailTextfield.sendKeys("1234567890");
	}
}
