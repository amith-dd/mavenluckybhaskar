package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserCreatedBoardsPage {
	WebDriver driver;

	public TrelloUserCreatedBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[aria-label='Show menu']")
	private WebElement showMenuButton;
	
	@FindBy(xpath = "//button[.='Close board']")
	private WebElement closeBoardMenuButton;
	
	@FindBy(xpath = "//button[.='Close']")
	private WebElement popOverCloseBoardButton;
	
	@FindBy(xpath = "//button[.='Permanently delete board']")
	private WebElement permanentlyDeleteButton;
	
	@FindBy(xpath = "//button[.='Delete']")
	private WebElement popOverDeleteBoardButton;

	public WebElement getShowMenuButton() {
		return showMenuButton;
	}

	public WebElement getCloseBoardMenuButton() {
		return closeBoardMenuButton;
	}

	public WebElement getPopOverCloseBoardButton() {
		return popOverCloseBoardButton;
	}

	public WebElement getPermanentlyDeleteButton() {
		return permanentlyDeleteButton;
	}

	public WebElement getPopOverDeleteBoardButton() {
		return popOverDeleteBoardButton;
	}
	
	
}
