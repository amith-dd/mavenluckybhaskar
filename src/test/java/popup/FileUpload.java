package popup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement fileUploadButton=driver.findElement(By.id("uploadfile_0"));
		Thread.sleep(4000);
//		fileUploadButton.click();
		Actions actions = new Actions(driver);
//		actions.moveToElement(fileUploadButton).pause(100).click(fileUploadButton).build().perform();
//		actions.sendKeys(fileUploadButton, "C:\\Users\\Chandan N R\\Desktop\\QCR-SJFJVD-M7\\myfile.txt").perform();
		fileUploadButton.sendKeys("C:\\Users\\Chandan N R\\Desktop\\QCR-SJFJVD-M7\\myfile.txt");
		driver.findElement(By.id("terms")).click(); 
		driver.findElement(By.id("submitbutton")).click();
	}
}
