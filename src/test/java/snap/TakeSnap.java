package snap;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TakeSnap {

	@Test
	public void webPageScreenShot() throws Throwable {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
//		System.out.println(srcFile.getAbsolutePath());
//		Thread.sleep(20000);
		File destFile = new File("./errorshots/facebooklogin.png");
		FileUtils.copyFile(srcFile, destFile);
		
	}

	@Test   
	public void webElementScreenShot() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement loginButton=driver.findElement(By.name("login"));
		File srcFile = loginButton.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./errorshots/loginButton.png");
		FileUtils.copyFile(srcFile, destFile);
	}
}
