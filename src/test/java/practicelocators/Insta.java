package practicelocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Insta {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// find the active element
		WebElement emailTextfield = driver.switchTo().activeElement();
		System.out.println(emailTextfield.getTagName());
//		emailTextfield.sendKeys("213456789");
		driver.quit();
	}
}
