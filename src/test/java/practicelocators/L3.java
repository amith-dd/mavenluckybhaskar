package practicelocators;

import java.net.http.WebSocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L3 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// NoSuchElementException - run - unchecked - Selenium - address is wrong -
		// dynamic
//	WebElement loginButton = driver.findElement(By.("u_0_5_di"));
		WebElement loginButton = driver.findElement(By.name("login"));
		loginButton.click();
	}
}
