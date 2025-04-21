package practicelocators;

import java.net.http.WebSocket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class L6 {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	//identify the password text field
	WebElement pwdTextfield = driver.findElement(By.id("pass"));
	pwdTextfield.sendKeys("213");
	Thread.sleep(3000);
	//identify the flutter button
	WebElement flutterButton = driver.findElement(By.className("_9lsa"));
	flutterButton.click();
}
}
