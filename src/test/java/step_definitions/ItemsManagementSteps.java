package step_definitions;

import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.ItemsPage;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.DButils;
import utilities.Driver;


public class ItemsManagementSteps {
	
	LogInPage loginPage = new LogInPage();
	ItemsPage itemsPage = new ItemsPage();
	CraterCommonPage commonPage = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutil = new DButils();
	
	static String itemName;
	static int itemId;
 	static List<String> list;
	
	

	//@createItemsFP
	@Given("As an entity user, I am logged in")
	public void as_an_enrity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		loginPage.login();
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() throws InterruptedException {
		Thread.sleep(1000);
		commonPage.itemsLink.click();
		Thread.sleep(1000);
	}
	

@When("I click on the Add Item button")
public void i_click_on_the_add_item_button() {
    itemsPage.addItemButton.click();
}
@Then("I should be on item input page")
public void i_should_be_on_item_input_page() {
	itemsPage.itemsPageHeaderText.getText();
	Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
}
@When("I provide item information {string}, {string}, {string}, and {string}")
public void i_provide_item_information_and(String name, String price, String unit, String description) {
	itemName = name + utils.randomNumber();
	itemsPage.addItemName.sendKeys(itemName);
	itemsPage.addItemPrice.sendKeys(price);
	itemsPage.addItemUnit.click();
	utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
itemsPage.addItemDesciption.sendKeys(description);
}

//@populationOfAddItemsTable
@Given("I click on the more icon represented by three dots for a given item")
public void i_click_on_the_more_icon_represented_by_three_dots_for_a_given_item() throws InterruptedException {
	 Thread.sleep(2000);
	   itemsPage.filterItem3dot.click();
}
@Given("I click on edit")
public void i_click_on_edit() {
	
	itemsPage.filter3dotEditBtn.click();
	
}
@Then("I should be directed to the Edit Item page")
public void i_should_be_directed_to_the_edit_item_page() throws InterruptedException {
	Thread.sleep(3000);
    itemsPage.editItemHeaderText.isDisplayed();
}
//@Then("I should be able to select {string}")
//public void i_should_be_able_to_select(String string) {
//	Driver.getDriver().findElement(By.xpath("//type[text()='"+itemName+"']")).click();
//}
@Then("I update the item to {int} dollars")
public void i_update_the_item_to_dollars(Integer price) throws InterruptedException {
	Thread.sleep(5000);
	itemsPage.itemsPriceField.clear();
		itemsPage.itemsPriceField.sendKeys(price.toString());
}
@When("I click on the update item button")
public void i_click_on_the_update_item_button() {
	 itemsPage.updateButton.click();
}
@Then("the Item price is updated to {int} dollars")
public void the_item_price_is_updated_to_dollars(Integer updatedPrice) {
		String itemXpath = "(//a[text()='"+itemName+"']//parent::td//following-sibling::td)[2]//span";
 	    String itemPrice = Driver.getDriver().findElement(By.xpath(itemXpath)).getText();
 	    System.out.println(itemPrice); 
 	    String trimmedPrice = itemPrice.substring(2);
 	    Assert.assertEquals(trimmedPrice, updatedPrice + ".00");
}
@Then("I should see a flash message {string} with a close button to the right")
public void i_should_see_a_flash_message_with_a_close_button_to_the_right(String string) {
	Assert.assertTrue(itemsPage.successMsgAddItem.isDisplayed());
}
@Then("I should be directed to the Items Page")
public void i_should_be_directed_to_the_items_page() {
    itemsPage.itemsPageHeaderText.isDisplayed();
}
@Then("I should be able to view that the item is updated within the items table")
public void i_should_be_able_to_view_that_the_item_is_updated_within_the_items_table() throws InterruptedException {
	if (!utils.isElementPresent(itemsPage.filterNameInputField)) {
		utils.waitUntilElementToBeClickable(itemsPage.filterButton);
		itemsPage.filterButton.click();
		utils.waitUntilElementVisible(itemsPage.filterNameInputField);
		utils.actionsSendKeys(itemsPage.filterNameInputField, itemName);
	}
	Thread.sleep(2000);
	Assert.assertTrue(
			Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
}

@Then("the application database should be updated with the Edits made by me for the respective item")
public void the_application_database_should_be_updated_with_the_edits_made_by_me_for_the_respective_item() {
	String query = "SELECT name, price, unit_id, description FROM items where name = '"+ itemName +"'";
	System.out.println(query);
	dbutil.selectArecord(query);
	List<String> itemInfo = dbutil.selectArecord(query);
	for (String string : itemInfo) {
		System.out.println(string);
	}
}



	//**************************************************//
	@Then("I should see the menu navigation path as Home Items placed under Items")
	public void i_should_see_the_menu_navigation_path_as_home_items_placed_under_items() throws InterruptedException {
		Assert.assertTrue(itemsPage.itemsMenuNavigationPathHome.isDisplayed());
		Thread.sleep(1000);
		itemsPage.itemsMenuNavigationPathHome.getText();
		Assert.assertTrue(itemsPage.itemsMenuNavigationPathforwardSlash.isDisplayed());
		Thread.sleep(1000);
		itemsPage.itemsMenuNavigationPathforwardSlash.getText();
		Assert.assertTrue(itemsPage.itemsMenuNavigationPathItems.isDisplayed());
		Thread.sleep(1000);
		itemsPage.itemsMenuNavigationPathItems.getText();
	}
	@Then("I should see a secondary button titled Filter")
	public void i_should_see_a_secondary_button_titled_filter() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemsPage.filterButton.isDisplayed());
		
	}
	@Then("I should see a primary button titled Add Item")
	public void i_should_see_a_primary_button_titled_add_item() throws InterruptedException {
		Assert.assertTrue(itemsPage.addItemButton.isDisplayed());
		Thread.sleep(1000);
		itemsPage.addItemButton.getText();
	}
	@Then("I should see a table with select all checkbox, NAME, UNIT, PRICE, ADDED ON")
	public void i_should_see_a_table_with_select_all_checkbox_name_unit_price_added_on() {
		Assert.assertTrue(itemsPage.itemsPageSelectAllPrimaryCheckBox.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageTableNameHeadingText.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageTableUnitHeadingText.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageTablePriceHeadingText.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageAddedOnHeadingText.isDisplayed());
		itemsPage.itemsPageAddedOnHeadingText.getText();

	}
	@Then("A link icon showing three dots")
	public void a_link_icon_showing_three_dots() {
		Assert.assertTrue(itemsPage.filterItem3dot.isDisplayed());
	}
	@When("I click on a link icon with three dots")
	public void i_click_on_a_link_icon_with_three_dots() throws InterruptedException {
	   Thread.sleep(2000);
	   itemsPage.filterItem3dot.click();
	}
	@Then("I should see Edit with an edit icon")
	public void i_should_see_edit_with_an_edit_icon() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemsPage.filter3dotEditBtn.isDisplayed());
		itemsPage.filter3dotEditBtn.getText();
	}
	@Then("I should see Delete with a delete icon")
	public void i_should_see_delete_with_a_delete_icon() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemsPage.filter3dotDeleteBtn.isDisplayed());
		itemsPage.filter3dotDeleteBtn.getText();
		Thread.sleep(2000);
		itemsPage.filterItem3dot.click();
	}
	
	@Then("Verify the pagination text at the bottom of the page")
	public void verify_the_pagination_text_at_the_bottom_of_the_page() throws InterruptedException {
		Thread.sleep(2000);
		String paginationText = "Showing 1 to 10 of";
		itemsPage.itemsPagePaginationText.getText();
		Thread.sleep(2000);
		Assert.assertTrue((itemsPage.itemsPagePaginationText.getText().contains(paginationText)));
	}

	@When("I click on right arrow navigation")
	public void i_click_on_right_arrow_navigation() throws InterruptedException {
		utils.waitUntilElementToBeClickable(itemsPage.itemPageRightPageNavigationBtn);
		utils.actionsClick(itemsPage.itemPageRightPageNavigationBtn);
	}
	@Then("I should navigate to the next page")
	public void i_should_navigate_to_the_next_page() throws InterruptedException {
		Thread.sleep(2000);
		utils.waitUntilElementVisible(itemsPage.itemPageSecondPage);
		Assert.assertTrue(itemsPage.itemPageSecondPage.isDisplayed());
		itemsPage.itemPageSecondPage.getText();
	}
	
	@When("I click on left arrow navigation")
	public void i_click_on_left_arrow_navigation() {
		utils.waitUntilElementToBeClickable(itemsPage.itemPageLeftPageNavigationBtn);
		utils.actionsClick(itemsPage.itemPageLeftPageNavigationBtn);
	}
	@Then("I should navigate to previous page")
	public void i_should_navigate_to_previous_page() throws InterruptedException {
		Thread.sleep(2000);
		utils.waitUntilElementVisible(itemsPage.itemPageFirstPage);
		Assert.assertTrue(itemsPage.itemPageFirstPage.isDisplayed());
		itemsPage.itemPageFirstPage.getText();
	}
	

	
	//@VerifyAddaItemUIcomponents
	
	@When("I click on Add Item button")
	public void i_click_on_add_item_button() {
		itemsPage.addItemButton.click();
	}
	@Then("I should be on New Item page")
	public void i_should_be_on_new_item_page() {
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}
	@Then("I should see fields Name, Price, Unit, Description")
	public void i_should_see_fields_name_price_unit_description() {
		Assert.assertTrue(itemsPage.addItemPageNameFieldText.isDisplayed());
		Assert.assertTrue(itemsPage.addItemPagePriceFieldText.isDisplayed());
		Assert.assertTrue(itemsPage.addItemPageUnitFieldText.isDisplayed());
		Assert.assertTrue(itemsPage.addItemPageDescriptionFieldText.isDisplayed());
	}


	//@ValidCreateItem
	
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, String price, String unit, String description) {
		itemName = name + utils.randomNumber();
		itemsPage.addItemName.sendKeys(itemName);
		itemsPage.addItemPrice.sendKeys(price);
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
	Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
	itemsPage.addItemDesciption.sendKeys(description);
	}
	
	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemsPage.saveItemButton.click();
	}
	@Then("I should see a flash message success")
	public void i_should_see_a_flash_message_success() {
		Assert.assertTrue(itemsPage.successMsgAddItem.isDisplayed());
	}

	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() throws InterruptedException {
		if (!utils.isElementPresent(itemsPage.filterNameInputField)) {
			utils.waitUntilElementToBeClickable(itemsPage.filterButton);
			itemsPage.filterButton.click();
			utils.waitUntilElementVisible(itemsPage.filterNameInputField);
			utils.actionsSendKeys(itemsPage.filterNameInputField, itemName);
		}
		Thread.sleep(2000);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
	}
	@Then("I should be able to see the item in database")
	public void i_should_be_able_to_see_the_item_in_database() {
		String query = "SELECT name, price, unit_id, description FROM items where name = '"+ itemName +"'";
		System.out.println(query);
		dbutil.selectArecord(query);
		List<String> itemInfo = dbutil.selectArecord(query);
		for (String string : itemInfo) {
			System.out.println(string);
		}
		
		Assert.assertEquals(itemName, itemInfo.get(0));
	}

	//@BlankNameFieldforCreateItem
	
	@When("I leave the name fild blank")
	public void i_leave_the_name_fild_blank() throws InterruptedException {
	    itemsPage.addItemName.sendKeys("");
	
	}
	
	@Then("I should see field is required error message")
	public void i_should_see_field_is_required_error_message() {
	    Assert.assertTrue(itemsPage.addItemPageFieldRequiredMsg.isDisplayed());
	}
	@Then("I should still be New Item page")
	public void i_should_still_be_new_item_page() {
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}
	
	//@InvalidNameFieldforCreateItem
	
	@When("I enter name as {string}")
	public void i_enter_name_as(String name) {
		itemsPage.addItemName.sendKeys(name);
	}
	@Then("I should see atleast three letters required error message")
	public void i_should_see_atleast_three_letters_required_error_message() {
		Assert.assertTrue(itemsPage.addItemPage3LettersRequiredMsg.isDisplayed());
	}
	
	//@FilterNameCreateItem
	
	@When("I click on Filter Icon")
	public void i_click_on_filter_icon() throws InterruptedException {
		if (!utils.isElementPresent(itemsPage.filterNameInputField)) {
			utils.waitUntilElementToBeClickable(itemsPage.filterButton);
			itemsPage.filterButton.click();
		}
		Thread.sleep(10000);
		utils.waitUntilElementToBeClickable(itemsPage.filterButton);
		itemsPage.filterButton.click();
		Thread.sleep(10000);

	}
	@Then("I should see Name, Unit, Price boxes")
	public void i_should_see_name_unit_price_boxes() {
		Assert.assertTrue(itemsPage.filterNameInputField.isDisplayed());
		Assert.assertTrue(itemsPage.itemsPageUnitInputField.isDisplayed());
		Assert.assertTrue(itemsPage.filterPriceInputField.isDisplayed());
	}
	@Then("I should see Clear All link")
	public void i_should_see_clear_all_link() {
		Assert.assertTrue(itemsPage.filterClearAll.isDisplayed());
	}
	@When("I type a name {string} in the Name text box")
	public void i_type_a_name_in_the_name_text_box(String name) {
		itemName = name;
		utils.actionsSendKeys(itemsPage.filterNameInputField, itemName);
	}
	@Then("I should get item matching the name")
	public void i_should_get_item_matching_the_name() {
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
	}
	@When("I click on the ‘Clear All’ link")
	public void i_click_on_the_clear_all_link() {
	   itemsPage.filterClearAll.click();
	}
	@Then("the application will display the current list of items")
	public void the_application_will_display_the_current_list_of_items() {
		Assert.assertTrue(itemsPage.itemPageShowingPagesMsg.isDisplayed());
	}
		
	@Then("I should see the name, unit, price, and clear all options disapear")
	public void i_should_see_the_name_unit_price_and_clear_all_options_disapear() {
		Assert.assertTrue(!itemsPage.filterNameBoxHeading.isDisplayed());
	}

	//@FilterUnitCreateItem
	
	@When("I type a {string} in the unit text box and click on it")
	public void i_type_a_in_the_unit_text_box_and_click_on_it(String unit) throws InterruptedException {
		utils.waitUntilElementToBeClickable(itemsPage.itemsPageUnitInputField);
		utils.actionsClick(itemsPage.itemsPageUnitInputField);
		Thread.sleep(5000);
		Driver.getDriver().findElement(By.xpath("//span[(text()= '"+unit+"')]")).click();
	}
	@Then("I should get item matching the unit with name {string}")
	public void i_should_get_item_matching_the_unit(String name) throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("(//a[text()='"+name+"']//parent::td//following-sibling::td)[1]")).isDisplayed());
	}
	
	
	//@NoResultFilterCreateItem
	@Then("I should no result found message")
	public void i_should_no_result_found_message() {
		Assert.assertTrue(itemsPage.filterNoResultFoundMessage.isDisplayed());
	}
	

}
