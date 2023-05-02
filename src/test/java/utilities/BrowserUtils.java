package utilities;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


//import utilites.Driver;

public class BrowserUtils {

	WebDriverWait wait;
	Select letsSelect;
	Actions action;

	
	
	//wait for an element to be visible
	public void waitUntilElementVisible(WebElement element) {
	 wait = new WebDriverWait(Driver.getDriver(), 20);
	 wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	//wait for an element to be gone
	public void waitUntilElementNotVisible(WebElement element) {
		 wait = new WebDriverWait(Driver.getDriver(), 20);
		 wait.until(ExpectedConditions.invisibilityOfAllElements(element));
			
		}
	// waits for an element to be gone
	public void waitUntilElementToBeClickable(WebElement element) {
		 wait = new WebDriverWait(Driver.getDriver(), 20);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
			
	}
	
	//sendkeys via actions class to the field that is not exteractable
	public void actionsSendKeys(WebElement element, String text) {
		action = new Actions(Driver.getDriver());
		action.sendKeys(element, text).build().perform();
	}
	
	
	// action click
	public void actionsClick(WebElement element) {
		Actions act = new Actions(Driver.getDriver());
		act.click(element).build().perform();
	
	}
	
	//select by visible text
	public void selectByVisibleText(WebElement selectElement, String tobeSelectedOptionText) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByVisibleText(tobeSelectedOptionText);
		
	}
	
	//select by value
	public void selectByValue(WebElement selectElement, String value) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByValue(value);
		
	}
	
	//select by index
	
	public void selectByVaIndex(WebElement selectElement, int index) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByIndex(index);
		
	}
	
	
	//return the selected option form the dropdown
	public String getSelectedOption(WebElement selectElement) {
		letsSelect = new Select(selectElement);
		String option = letsSelect.getFirstSelectedOption().getText();
		return option;
	}
	
	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
	// this method checks if an element exist in the dom (in the whole html)
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	
	

	
}
