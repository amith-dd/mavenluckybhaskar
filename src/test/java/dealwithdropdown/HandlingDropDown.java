package dealwithdropdown;

import java.util.List;

import org.apache.poi.ss.formula.functions.Days;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;

public class HandlingDropDown extends BaseClass {

	@Test
	public void noOptionsInDropDown() {
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		// getOptions() it will capture all the options in the Dropdown list box.
		List<WebElement> allDayOptions = daySelect.getOptions();
		int noOfDayOptions = allDayOptions.size();
		System.out.println("noOfDayOptions: " + noOfDayOptions);
	}

	@Test
	public void printAllOptionsInTheListBox() {
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		// getOptions() it will capture all the options in the Dropdown list box.
		List<WebElement> allDayOptions = daySelect.getOptions();
//		System.out.println(allDayOptions); Not to do before iteration
		for (WebElement dayOption : allDayOptions) {
			// Every Option In dropdown is made with <option> and it's tag text
			String dayOptionName = dayOption.getText();
			System.out.println(dayOptionName);
		}
	}

	@Test
	public void selectAnOptionByName() {
		WebElement dayDropDown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropDown);
		// By using <option> tag text select an option - selectByVisibleText()
		daySelect.selectByVisibleText("3");
	}

	@Test
	public void selectYourDobBySelectByVisibleText() {
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		System.out.println("allDropDowns Count is: " + allDropDowns.size());
		for (WebElement dropdown : allDropDowns) {
			if (dropdown.isDisplayed()) {
				System.out.println("DropDown is visible");
				Select dropdownSelect = new Select(dropdown);
				if (dropdown.getDomAttribute("title").equals("Day")) {
					dropdownSelect.selectByVisibleText("22");
				} else if (dropdown.getDomAttribute("title").equals("Month")) {
					dropdownSelect.selectByVisibleText("Jun");
				} else if (dropdown.getDomAttribute("title").equals("Year")) {
					dropdownSelect.selectByVisibleText("1974");
				}
			} else {
				System.out.println("DropDown is Invisible");
			}
		}
	}

	@Test
	public void selectYourDobBySelectByValue() {
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		System.out.println("allDropDowns Count is: " + allDropDowns.size());
		for (WebElement dropdown : allDropDowns) {
			if (dropdown.isDisplayed()) {
				System.out.println("DropDown is visible");
				Select dropdownSelect = new Select(dropdown);
				if (dropdown.getDomAttribute("title").equals("Day")) {
					dropdownSelect.selectByValue("22");
				} else if (dropdown.getDomAttribute("title").equals("Month")) {
					dropdownSelect.selectByValue("6");
				} else if (dropdown.getDomAttribute("title").equals("Year")) {
					dropdownSelect.selectByValue("1974");
				}
			} else {
				System.out.println("DropDown is Invisible");
			}
		}
	}

	@Test
	public void selectYourDobBySelectByIndex() {
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		System.out.println("allDropDowns Count is: " + allDropDowns.size());
		for (WebElement dropdown : allDropDowns) {
			if (dropdown.isDisplayed()) {
				System.out.println("DropDown is visible");
				Select dropdownSelect = new Select(dropdown);
				if (dropdown.getDomAttribute("title").equals("Day")) {
					dropdownSelect.selectByIndex(23);
				} else if (dropdown.getDomAttribute("title").equals("Month")) {
					dropdownSelect.selectByIndex(5);
				} else if (dropdown.getDomAttribute("title").equals("Year")) {
					dropdownSelect.selectByIndex(51);
				}
			} else {
				System.out.println("DropDown is Invisible");
			}
		}
	}

	@Test
	public void defaultSelectedOptionOInListBox() {
		List<WebElement> allDropDowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropDowns) {
			if (dropdown.isDisplayed()) {
				Select dropdownSelect = new Select(dropdown);
				String defaultSelectedIOptionName = dropdownSelect.getFirstSelectedOption().getText();
				System.out.println("defaultSelectedIOptionName: " + defaultSelectedIOptionName);
			}
		}
	}

	@Test
	public void checkForSepMonthSelection() {
		// Select Sep Month in the list box
		// verify that whether Sep is Selected or no

	}

	@Test
	public void typeOfDropdown() {
		WebElement dayDropdown = driver.findElement(By.id("day"));
		Select daySelect = new Select(dayDropdown);
		if (daySelect.isMultiple()) {
			System.out.println("Boolean True - Multi Select");
		} else {
			System.out.println("Boolean False - Single Select");
		}
	}

}
