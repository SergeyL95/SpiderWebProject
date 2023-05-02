package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.ItemsPage;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.DataReader;
import utilities.Driver;


public class ItemsManagementSteps {
	 LogInPage loginPage = new  LogInPage();
	 ItemsPage itemsPage =new ItemsPage();
	 CraterCommonPage commonPage = new CraterCommonPage();
	 BrowserUtils utils = new BrowserUtils();
	 DButils dbutil = new DButils();
	 
	 
	   static String itemName;
@Given("I am an external user of the {string}")
public void i_am_an_external_user_of_the(String string) {
    Driver.getDriver().get(DataReader.getProperty("appUrl"));
    loginPage.login();
}
@Given("I navigate to Items tab")
public void i_navigate_to_items_tab() {
	commonPage.itemsLink.click();
	  Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());
}

@When("I click on the Add Item button")
public void i_click_on_the_add_item_button() {
  itemsPage.addItemButton.click();
}
@Then("I should be on item input page")
public void i_should_be_on_item_input_page() {
	Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
}
@When("I provide item information {string}, {string}, {string}, and {string}")
public void i_provide_item_information_and(String name, String price, String unit, String description) {
	itemName = name + utils.randomNumber();
		itemsPage.addItemName.sendKeys(itemName);
		itemsPage.addItemPrice.sendKeys(price.toString());
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
		itemsPage.addItemDesciption.sendKeys(description);
}
@When("I click Save Item button")
public void i_click_save_item_button() {
   itemsPage.saveItemButton.click();
}
@Then("The Item is added to the Item list table")
public void the_item_is_added_to_the_item_list_table() {
	if (!utils.isElementPresent(itemsPage.filterNameBox)) {
			utils.waitUntilElementToBeClickable(itemsPage.filterButton);
			itemsPage.filterButton.click();
			utils.waitUntilElementVisible(itemsPage.filterNameBox);
			utils.actionsSendKeys(itemsPage.filterNameBox, itemName);
}

}
	@Given("I click on the more icon represented by three dots for a given item")
	public void i_click_on_the_more_icon_represented_by_three_dots_for_a_given_item() {
	    itemsPage.filterItem3dot.click();
	}
	@Given("I click on edit")
	public void i_click_on_edit() {
	    itemsPage.edit3dotBtn.click();
	}
	@Then("I should be directed to the Edit Item page")
	public void i_should_be_directed_to_the_edit_item_page() {
	    Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	}
	@Then("I should be able to view all the item fields")
	public void i_should_be_able_to_view_all_the_item_fields_mentioned_in_ac(Integer int1) {
	    Assert.assertTrue(itemsPage.addItemName.isDisplayed());
	    Assert.assertTrue(itemsPage.addItemPrice.isDisplayed());
	    Assert.assertTrue(itemsPage.addItemUnit.isDisplayed());
	    Assert.assertTrue(itemsPage.addItemDesciption.isDisplayed());
	}
	@Then("I should be able to edit all the item fields")
	public void i_should_be_able_to_edit_all_the_item_fields_mentioned_in_ac(Integer price) {
 		itemsPage.addItemPrice.clear();
 		itemsPage.addItemPrice.sendKeys(price.toString());
	}
	@Then("the application should perform the validations for each respective field")
	public void the_application_should_perform_the_validations_for_each_respective_field_as_mentioned_in_ac(Integer int1) {
	   
	}
	@When("I click on the {string} button")
	public void i_click_on_the_button(String updateItem) {
		itemsPage.updateButton.click();
	}
	@Then("I should see a flash message {string} with a close button to the right")
	public void i_should_see_a_flash_message_with_a_close_button_to_the_right(String string) {
	   
	}
	@Then("the flash message should disappear within {int} seconds or less")
	public void the_flash_message_should_disappear_within_seconds_or_less(Integer int1) {
	    
	}
	@Then("I can close the flash message by clicking on the {string} button")
	public void i_can_close_the_flash_message_by_clicking_on_the_button(String string) {
	   
	}
	@Then("I should be directed to the Items Page")
	public void i_should_be_directed_to_the_items_page() {
	    
	}
	@Then("I should be able to view that the item is updated within the items table")
	public void i_should_be_able_to_view_that_the_item_is_updated_within_the_items_table() {
	   
	}
	@Then("the application database should be updated with the Edits made by me for the respective item")
	public void the_application_database_should_be_updated_with_the_edits_made_by_me_for_the_respective_item() {
	   
	}
}

