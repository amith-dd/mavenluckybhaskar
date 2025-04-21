package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class TrelloHomePage {
	WebDriver driver;

	public TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[.='Features' and @data-testid]")
	private WebElement featuresButton;
	
	@FindBy(xpath = "//button[.='Solutions' and @data-testid]")
	private WebElement solutionsButton;
	
	@FindBy(xpath = "//button[.='Plans' and @data-testid]")
	private WebElement plansButton;
	
	@FindBy(xpath = "//button[not(@tabindex) and .='Plans']/following-sibling::a[.='Pricing']")
	private WebElement priceOption;
	
	@FindBy(xpath = "//button[.='Resources' and @data-testid]")
	private WebElement resourcesButton;
	
	@FindBy(xpath = "//a[.='Get Trello for free']/preceding-sibling::a[.='Log in']")
	private WebElement loginOption;

	@FindBy(xpath = "//span[.='Watch video']/preceding::input[@name='email']")
	private WebElement emailToSignUpTextField;
	
	@FindBy(xpath = "//span[.='Watch video']/preceding::button[text()=\"Sign up - it’s free!\"]")
	private WebElement freeSignUpSubmitButton;
	
	
	
	public WebElement getEmailToSignUpTextField() {
		return emailToSignUpTextField;
	}

	public WebElement getFreeSignUpSubmitButton() {
		return freeSignUpSubmitButton;
	}

	public WebElement getFeaturesButton() {
		return featuresButton;
	}

	public WebElement getSolutionsButton() {
		return solutionsButton;
	}

	public WebElement getPlansButton() {
		return plansButton;
	}

	public WebElement getPriceOption() {
		return priceOption;
	}

	public WebElement getResourcesButton() {
		return resourcesButton;
	}
	
	public WebElement getLoginOption() {
		return loginOption;
	}
}
