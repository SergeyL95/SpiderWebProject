package step_definitions;

import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
	
	LogInPage loginpage = new LogInPage();
	ItemsPage itemspage = new ItemsPage();
	CraterCommonPage commonPage = new CraterCommonPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutil = new DButils();
	
	static String itemName;
	
	
	//@VerifyUIComponentsOnItemsPage
	
	@Given("As an enrity user, I am logged in")
	public void as_an_enrity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		loginpage.login();
	}
	
	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() throws InterruptedException {
		Thread.sleep(1000);
		commonPage.itemsLink.click();
		Thread.sleep(1000);
	}
	
	@Then("I should be navigated to a page titled Items")
	public void i_should_be_navigated_to_a_page_titled_items() {
		Assert.assertTrue(itemspage.itemsPageHeaderText.isDisplayed());
		itemspage.itemsPageHeaderText.getText();
	}
	@Then("I should see the menu navigation path as Home Items placed under Items")
	public void i_should_see_the_menu_navigation_path_as_home_items_placed_under_items() throws InterruptedException {
		Assert.assertTrue(itemspage.itemsMenuNavigationPathHome.isDisplayed());
		Thread.sleep(1000);
		itemspage.itemsMenuNavigationPathHome.getText();
		Assert.assertTrue(itemspage.itemsMenuNavigationPathforwardSlash.isDisplayed());
		Thread.sleep(1000);
		itemspage.itemsMenuNavigationPathforwardSlash.getText();
		Assert.assertTrue(itemspage.itemsMenuNavigationPathItems.isDisplayed());
		Thread.sleep(1000);
		itemspage.itemsMenuNavigationPathItems.getText();
	}
	@Then("I should see a secondary button titled Filter")
	public void i_should_see_a_secondary_button_titled_filter() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemspage.filterButton.isDisplayed());
		
	}
	@Then("I should see a primary button titled Add Item")
	public void i_should_see_a_primary_button_titled_add_item() throws InterruptedException {
		Assert.assertTrue(itemspage.addItemButton.isDisplayed());
		Thread.sleep(1000);
		itemspage.addItemButton.getText();
	}
	@Then("I should see a table with select all checkbox, NAME, UNIT, PRICE, ADDED ON")
	public void i_should_see_a_table_with_select_all_checkbox_name_unit_price_added_on() {
		Assert.assertTrue(itemspage.itemsPageSelectAllPrimaryCheckBox.isDisplayed());
		Assert.assertTrue(itemspage.itemsPageTableNameHeadingText.isDisplayed());
		Assert.assertTrue(itemspage.itemsPageTableUnitHeadingText.isDisplayed());
		Assert.assertTrue(itemspage.itemsPageTablePriceHeadingText.isDisplayed());
		Assert.assertTrue(itemspage.itemsPageAddedOnHeadingText.isDisplayed());
		itemspage.itemsPageAddedOnHeadingText.getText();

	}
	@Then("A link icon showing three dots")
	public void a_link_icon_showing_three_dots() {
		Assert.assertTrue(itemspage.filterItem3dot.isDisplayed());
	}
	@When("I click on a link icon with three dots")
	public void i_click_on_a_link_icon_with_three_dots() throws InterruptedException {
	   Thread.sleep(2000);
	   itemspage.filterItem3dot.click();
	}
	@Then("I should see Edit with an edit icon")
	public void i_should_see_edit_with_an_edit_icon() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemspage.filter3dotEditBtn.isDisplayed());
		itemspage.filter3dotEditBtn.getText();
	}
	@Then("I should see Delete with a delete icon")
	public void i_should_see_delete_with_a_delete_icon() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(itemspage.filter3dotDeleteBtn.isDisplayed());
		itemspage.filter3dotDeleteBtn.getText();
		Thread.sleep(2000);
		itemspage.filterItem3dot.click();
	}
	
	@Then("Verify the pagination text at the bottom of the page")
	public void verify_the_pagination_text_at_the_bottom_of_the_page() throws InterruptedException {
		Thread.sleep(2000);
		String paginationText = "Showing 1 to 10 of";
		itemspage.itemsPagePaginationText.getText();
		Thread.sleep(2000);
		Assert.assertTrue((itemspage.itemsPagePaginationText.getText().contains(paginationText)));
	}

	@When("I click on right arrow navigation")
	public void i_click_on_right_arrow_navigation() throws InterruptedException {
		utils.waitUntilElementToBeClickable(itemspage.itemPageRightPageNavigationBtn);
		utils.actionsClick(itemspage.itemPageRightPageNavigationBtn);
	}
	@Then("I should navigate to the next page")
	public void i_should_navigate_to_the_next_page() throws InterruptedException {
		Thread.sleep(2000);
		utils.waitUntilElementVisible(itemspage.itemPageSecondPage);
		Assert.assertTrue(itemspage.itemPageSecondPage.isDisplayed());
		itemspage.itemPageSecondPage.getText();
	}
	
	@When("I click on left arrow navigation")
	public void i_click_on_left_arrow_navigation() {
		utils.waitUntilElementToBeClickable(itemspage.itemPageLeftPageNavigationBtn);
		utils.actionsClick(itemspage.itemPageLeftPageNavigationBtn);
	}
	@Then("I should navigate to previous page")
	public void i_should_navigate_to_previous_page() throws InterruptedException {
		Thread.sleep(2000);
		utils.waitUntilElementVisible(itemspage.itemPageFirstPage);
		Assert.assertTrue(itemspage.itemPageFirstPage.isDisplayed());
		itemspage.itemPageFirstPage.getText();
	}
	
	@Then("right arrow is disabled when I am on last {int} page")
	public void right_arrow_is_disabled_when_i_am_on_last_page(Integer lastPage) throws InterruptedException {
		Thread.sleep(2000);
		Driver.getDriver().findElement(By.xpath("//a[text()='"+lastPage+"']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(itemspage.itemsFirstAndLastPageArrowDisabled.isDisplayed());
	}
	@Then("left arrow is disabled when I am on first {int} page")
	public void left_arrow_is_disabled_when_i_am_on_first_page(Integer firstPage) throws InterruptedException {
		utils.waitUntilElementToBeClickable(itemspage.itemPageFirstPage);
		itemspage.itemPageFirstPage.click();;
		Assert.assertTrue(itemspage.itemsFirstAndLastPageArrowDisabled.isDisplayed());
	}
	
	//@VerifyAddaItemUIcomponents
	
	@When("I click on Add Item button")
	public void i_click_on_add_item_button() {
		itemspage.addItemButton.click();
	}
	@Then("I should be on New Item page")
	public void i_should_be_on_new_item_page() {
		Assert.assertTrue(itemspage.addItemPageHeaderText.isDisplayed());
	}
	@Then("I should see fields Name, Price, Unit, Description")
	public void i_should_see_fields_name_price_unit_description() {
		Assert.assertTrue(itemspage.addItemPageNameFieldText.isDisplayed());
		Assert.assertTrue(itemspage.addItemPagePriceFieldText.isDisplayed());
		Assert.assertTrue(itemspage.addItemPageUnitFieldText.isDisplayed());
		Assert.assertTrue(itemspage.addItemPageDescriptionFieldText.isDisplayed());
	}


	//@ValidCreateItem
	
	@When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, String price, String unit, String description) {
		itemName = name + utils.randomNumber();
		itemspage.addItemName.sendKeys(itemName);
		itemspage.addItemPrice.sendKeys(price);
		itemspage.addItemUnit.click();
		utils.waitUntilElementVisible(itemspage.addItem_pc_unit);
	Driver.getDriver().findElement(By.xpath("//span[text()='"+unit+"']")).click();
	itemspage.addItemDesciption.sendKeys(description);
	}
	
	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemspage.saveItemButton.click();
	}
	@Then("I should see a flash message “Success! Item created successfully” with a close button to the right.")
	public void i_should_see_a_flash_message_success_item_created_successfully_with_a_close_button_to_the_right() {
		Assert.assertTrue(itemspage.successMsgAddItem.isDisplayed());
	}
	@Then("The flash message should disappear within five seconds or less.")
	public void the_flash_message_should_disappear_within_five_seconds_or_less() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(!itemspage.successMsgAddItem.isDisplayed());
	}
	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() throws InterruptedException {
		if (!utils.isElementPresent(itemspage.filterNameInputField)) {
			utils.waitUntilElementToBeClickable(itemspage.filterButton);
			itemspage.filterButton.click();
			utils.waitUntilElementVisible(itemspage.filterNameInputField);
			utils.actionsSendKeys(itemspage.filterNameInputField, itemName);
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
	public void i_leave_the_name_fild_blank() {
	    itemspage.addItemName.click();
	    itemspage.addItemButton.click();
	}
	
	@Then("I should see field is required error message")
	public void i_should_see_field_is_required_error_message() {
	    Assert.assertTrue(itemspage.addItemPageFieldRequiredMsg.isDisplayed());
	}
	@Then("I should still be New Item page")
	public void i_should_still_be_new_item_page() {
		Assert.assertTrue(itemspage.addItemPageHeaderText.isDisplayed());
	}
	
	//@InvalidNameFieldforCreateItem
	
	@When("I enter name as {string}")
	public void i_enter_name_as(String name) {
		itemspage.addItemName.sendKeys(name);
		itemspage.addItemButton.click();
	}
	@Then("I should see atleast three letters required error message")
	public void i_should_see_atleast_three_letters_required_error_message() {
		Assert.assertTrue(itemspage.addItemPage3LettersRequiredMsg.isDisplayed());
	}
	
	//@FilterNameCreateItem
	
	@When("I click on Filter Icon")
	public void i_click_on_filter_icon() throws InterruptedException {
		if (!utils.isElementPresent(itemspage.filterNameInputField)) {
			utils.waitUntilElementToBeClickable(itemspage.filterButton);
			itemspage.filterButton.click();
			utils.waitUntilElementVisible(itemspage.filterNameInputField);
			utils.actionsSendKeys(itemspage.filterNameInputField, itemName);
		}
		Thread.sleep(10000);
		itemspage.filterButton.click();
		utils.waitUntilElementVisible(itemspage.filterNameInputField);
		utils.actionsSendKeys(itemspage.filterNameInputField, itemName);
	}
	@Then("I should see Name, Unit, Price boxes")
	public void i_should_see_name_unit_price_boxes() {
		Assert.assertTrue(itemspage.filterNameBoxHeading.isDisplayed());
		Assert.assertTrue(itemspage.filterNameInputField.isDisplayed());
		Assert.assertTrue(itemspage.filterUnitBoxHeading.isDisplayed());
		Assert.assertTrue(itemspage.itemsPageUnitInputField.isDisplayed());
		Assert.assertTrue(itemspage.filterPriceBoxHeadingField.isDisplayed());
		Assert.assertTrue(itemspage.filterPriceInputField.isDisplayed());
	}
	@Then("I should see Clear All link")
	public void i_should_see_clear_all_link() {
		Assert.assertTrue(itemspage.filterClearAll.isDisplayed());
	}
	@When("I type a name in the Name text box")
	public void i_type_a_name_in_the_name_text_box() {
		utils.actionsSendKeys(itemspage.filterNameInputField, itemName);
		Assert.assertTrue(itemspage.filterPriceInputField.isDisplayed());
	}
	@Then("I should get item matching the name")
	public void i_should_get_item_matching_the_name() {
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
	}
	@When("I click on the ‘Clear All’ link")
	public void i_click_on_the_clear_all_link() {
	   itemspage.filterClearAll.click();
	}
	@Then("the application will display the current list of items")
	public void the_application_will_display_the_current_list_of_items() {
		Assert.assertTrue(itemspage.itemPageShowingPagesMsg.isDisplayed());
	}
	@When("I  click on the ‘Filter’ button again")
	public void i_click_on_the_filter_button_again() {
		itemspage.filterButton.click();
	}
	@Then("I should see the name, unit, price, and clear all options disapear")
	public void i_should_see_the_name_unit_price_and_clear_all_options_disapear() {
		Assert.assertTrue(!itemspage.filterNameBoxHeading.isDisplayed());
	}

	//@FilterUnitCreateItem
	
	@When("I type a {string} in the unit text box and click on it")
	public void i_type_a_in_the_unit_text_box_and_click_on_it(String unit) throws InterruptedException {
		itemspage.itemsPageUnitInputField.click();
		itemspage.itemsPageUnitInputText.sendKeys(unit);
		Thread.sleep(5000);
		itemspage.itemsPageUnitInputText.sendKeys(Keys.ENTER);
		
	}
	@Then("I should get item matching the unit")
	public void i_should_get_item_matching_the_unit() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
	}
	
	//@FilterPriceCreateItem
	
	@When("I type a {string} in the price text box")
	public void i_type_a_in_the_price_text_box(String price) {
		itemspage.filterPriceInputField.sendKeys(price);
	}
	@Then("I should get item matching the price")
	public void i_should_get_item_matching_the_price() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(
				Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
	}
	
	//@NoResultFilterCreateItem
	@Then("I should no result found message")
	public void i_should_no_result_found_message() {
		Assert.assertTrue(itemspage.filterNoResultFoundMessage.isDisplayed());
	}
	

}
