package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;

	public TrelloBoardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[.='Create new board']")
	private WebElement createNewBoardOption;

	@FindBy(css = "input[data-testid='create-board-title-input']")
	private WebElement boardTitleTextfield;

	@FindBy(css = "button[data-testid='create-board-submit-button']")
	private WebElement createBoardButton;

	@FindBy(css = "button[data-testid='header-member-menu-button']")
	private WebElement profileIconMenu;

	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutButton;

	public WebElement getCreateNewBoardOption() {
		return createNewBoardOption;
	}

	public WebElement getBoardTitleTextfield() {
		return boardTitleTextfield;
	}

	public WebElement getCreateBoardButton() {
		return createBoardButton;
	}

	public WebElement getProfileIconMenu() {
		return profileIconMenu;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
