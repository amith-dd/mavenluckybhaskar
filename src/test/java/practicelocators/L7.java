package practicelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class L7 {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://goldensandindia.com/");
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement smartPhoneCases = driver
				.findElement(By.xpath("//a[contains(.,'Smartphone Cases') and not(@class)]"));
		// mouse hovering on Smart Phones
		actions.moveToElement(smartPhoneCases).perform();
		Thread.sleep(2000);
		WebElement iphone16 = driver
				.findElement(By.xpath("//a[contains(@href,'apple-cases')]/following::span[text()='iPhone 16']"));
		// click on Iphone 16 option
		actions.moveToElement(iphone16).click().perform();
		Thread.sleep(2000);
		WebElement addtoCartButton = driver.findElement(By.xpath(
				"//a[contains(.,'Aramid Fibre Series Shockproof Armor Back Cover for Apple iPhone 16, 6.1 inch, Black') and not(@title)]/../..//button[contains(.,'ADD TO CART')]"));
		actions.scrollToElement(addtoCartButton).pause(2000).click(addtoCartButton).perform();
		Thread.sleep(2000);
		WebElement proceedToCheckOut = driver.findElement(By.xpath(
				"//div[@id='modalAddToCartProduct']//a[text()='PROCEED TO CHECKOUT' and @class='btn ttmodalbtn']"));
		actions.moveToElement(proceedToCheckOut).pause(200).click(proceedToCheckOut).click().perform();
	}
}
