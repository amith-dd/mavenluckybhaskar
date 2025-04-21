package datadriventestingpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.FaceBookSignUpPage;

public class CheckDropDown extends BaseClass {
	@Test
	public void checkOptionsOrder() throws Throwable, Throwable, Throwable {
		List<String> expectedDayOptionName = new ArrayList<String>();
		List<String> actualDayOptionName = new ArrayList<String>();
		FaceBookSignUpPage fbSignUp = new FaceBookSignUpPage(driver);
		for (WebElement dropdown : fbSignUp.getDobDropDowns()) {
			if (dropdown.getDomAttribute("title").equals("Day")) {
				for (WebElement dayOption :  new Select(dropdown).getOptions()) {
					actualDayOptionName.add(dayOption.getText());
				}
			}
		}
		for (short i = 0; i < excelUtils.rowCellLimit("dobdata", 0); i++) {
			expectedDayOptionName.add(String.valueOf((long) excelUtils.readNumericData("dobdata", 0, i)));
		}
		if (expectedDayOptionName.equals(actualDayOptionName)) {
			System.out.println("The Day DropDown Order is correct and it is verified");
			System.out.println(expectedDayOptionName);
			System.out.println(actualDayOptionName);
		} else {
			System.out.println("The Day DropDown Order is Incorrect and it is verified");
			System.out.println(expectedDayOptionName);
			System.out.println(actualDayOptionName);
		}
	}
}
