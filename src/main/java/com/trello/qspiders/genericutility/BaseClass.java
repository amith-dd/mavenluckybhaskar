package com.trello.qspiders.genericutility;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public JavaUtility javaUtils = new JavaUtility();
	public WebDriverUtility webdriverUtils = new WebDriverUtility();
	public ExcelUtility excelUtils = new ExcelUtility();

	@BeforeMethod
	public void configBeforeMethod() throws FileNotFoundException, IOException {
		// Get the Browser name from property file
		String browserName = javaUtils.readDataFromPropertyFile("browsername");
		// Choose the browser to launch
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		// Maximize the launched browser
		webdriverUtils.max(driver);
		// Trigger The url
		driver.get(javaUtils.readDataFromPropertyFile("url"));
	}

	@AfterMethod
	public void configAfterMethod() {
		webdriverUtils.min(driver);
		driver.quit();
	}
}
