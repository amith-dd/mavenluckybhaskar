package popup;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileDownLoad {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/downloads/");
		WebElement fileDownLoadLink = driver.findElement(By.linkText("4.31.0"));
		Actions actions = new Actions(driver);
		actions.scrollToElement(fileDownLoadLink).pause(100).click(fileDownLoadLink).build().perform();
		// reach the downloads page
		driver.get("chrome://downloads/");
//		WebElement shadowHost1 = driver.findElement(By.tagName("downloads-manager"));
//		SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
//		WebElement shadowhost2 = shadowRoot1.findElement(By.cssSelector("downloads-item[id='frb0']"));
//		SearchContext shadowRoot2 = shadowhost2.getShadowRoot();
//		WebElement moreActionsIcon = shadowRoot2.findElement(By.cssSelector("cr-icon-button[id='more-actions']"));
//		moreActionsIcon.click();
		driver.findElement(By.tagName("downloads-manager")).getShadowRoot()
				.findElement(By.cssSelector("downloads-item[id='frb0']")).getShadowRoot()
				.findElement(By.cssSelector("cr-icon-button[id='more-actions']")).click();
		actions.sendKeys(Keys.ARROW_DOWN).pause(100).sendKeys(Keys.ENTER).build().perform();

	}
}
