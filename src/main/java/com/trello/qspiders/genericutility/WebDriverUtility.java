package com.trello.qspiders.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This Class will be used to derive the capability of Selenium WebDriver [I]
 * All methods are browser controlling features given by Selenium WebDriver
 */
public class WebDriverUtility {
	/**
	 * It will be used to maximize the browser as a pre-condition.
	 * 
	 * @param driver
	 */
	public void max(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will be used to minimize the browser as a post-condition.
	 * 
	 * @param driver
	 */
	public void min(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This mehtod will be used to TAKE the browser to the full screen mode.
	 * 
	 * @param driver
	 */
	public void fullscreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	public WebDriver createNewTab(WebDriver driver) {
		WebDriver newTabDriver = driver.switchTo().newWindow(WindowType.TAB);
		return newTabDriver;
	}

	public WebDriver createNewWindow(WebDriver driver) {
		WebDriver newWindowDriver = driver.switchTo().newWindow(WindowType.WINDOW);
		return newWindowDriver;
	}

	public void switchToWindow(WebDriver driver, String wid) {
		driver.switchTo().window(wid);
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	/**
	 * This method will used to wait for the DOM Title to load.
	 * 
	 * @param driver
	 * @param expectedTitle
	 * @return
	 */
	public boolean waitForCompleteTitle(WebDriver driver, String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean result = wait.until(ExpectedConditions.titleIs(expectedTitle));
		return result;
	}
/**
 * This method will be used to wait for the DOM URL Fraction.
 * @param driver
 * @param expectedPartialUrl
 * @return
 */
	public boolean waitForPartialUrl(WebDriver driver, String expectedPartialUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean result = wait.until(ExpectedConditions.urlContains(expectedPartialUrl));
		return result;
	}
	
}
