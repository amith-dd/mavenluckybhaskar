package com.trello.qspiders.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookSignUpPage {
	WebDriver driver;

	public FaceBookSignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@data-type='selectors']//select")
	private List<WebElement> dobDropDowns;

	@FindBy(name = "websubmit")
	private WebElement signUpSubmitButton;

	@FindBy(xpath = "//label[.='Female']/input[@type='radio']")
	private WebElement femaleRadioButton;

	@FindBy(xpath = "//label[.='Male']/input[@type='radio']")
	private WebElement maleRadioButton;

	@FindBy(xpath = "//label[.='Custom']/input[@type='radio']")
	private WebElement customRadioButton;

	@FindBy(id = "preferred_pronoun")
	private WebElement preferredPronounListBox;

	public List<WebElement> getDobDropDowns() {
		return dobDropDowns;
	}

	public WebElement getSignUpSubmitButton() {
		return signUpSubmitButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getCustomRadioButton() {
		return customRadioButton;
	}

	public WebElement getPreferredPronounListBox() {
		return preferredPronounListBox;
	}

}
