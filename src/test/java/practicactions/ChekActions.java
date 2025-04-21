package practicactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ChekActions {
	@Test
	public void moveCursorOnToMen() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.myntra.com/");
		// identify the men section
		WebElement menSection = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
		Actions actions = new Actions(driver);
//		actions.moveToElement(menSection).perform();
		actions.moveToElement(menSection, 73, 0).perform();
	}

	@Test
	public void moveToHyperLink() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement hyperLink = driver.findElement(By.linkText("Forgotten password?"));
		// get The location of the element
		Point hyperLinkLocation = hyperLink.getLocation();
		System.out.println(hyperLinkLocation);
		Actions actions = new Actions(driver);
		actions.moveToLocation(hyperLinkLocation.getX(), hyperLinkLocation.getY()).perform();
	}

	@Test
	public void appendingData() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement emailTextField = driver.switchTo().activeElement();
		Actions actions = new Actions(driver);
//		actions.sendKeys("1234567890").perform();
		actions.sendKeys("1234567890").sendKeys(Keys.TAB).sendKeys("1234").build().perform();
		actions.pause(2000).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE)
				.sendKeys("0987654321").build().perform();
	}
	@Test
	public void check() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		//identify the right click button
//		WebElement rightClickButton=driver.findElement(By.xpath("//span[text()='right click me']"));
		//perform the right click on the button
		Actions actions = new Actions(driver);
//		actions.contextClick(rightClickButton).perform();
//		actions.moveToElement(rightClickButton).contextClick().perform();
		//Identify the double click button 
 		WebElement button = driver.findElement(By.tagName("button"));
// 		actions.doubleClick(button).perform();
 		actions.moveToElement(button).doubleClick().perform();
	}
	@Test
	public void dragAndDropPractice() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");	
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
//		actions.dragAndDrop(draggable, droppable).perform();
//		actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).drag.release().build().perform();
//		actions.dragAndDropBy(draggable, 160, 25).perform();
	}
}
