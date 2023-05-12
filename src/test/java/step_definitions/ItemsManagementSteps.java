package step_definitions;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;

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
		String itemXpath = ("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]");
 	    String itemPrice = Driver.getDriver().findElement(By.xpath(itemXpath)).getText();
 	    System.out.println(itemPrice); 
 	    String trimmedPrice = itemPrice.substring(2);
 	    Assert.assertEquals(trimmedPrice, updatedPrice + ".00");
}
@Then("I should see a flash message success")
public void i_should_see_a_flash_message_success() {
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
			Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[4]\n"
					+ "")).isDisplayed());
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

//@Deletinganitem
@When("I create an item with following information")
public void i_create_an_item_with_following_information(DataTable dataTable) {
	list = dataTable.asList();
    itemName = list.get(0) + utils.randomNumber();
    itemsPage.createAnItem(itemName, list.get(1), list.get(2), list.get(3));
    
}

@When("I click Save Item button")
public void i_click_save_item_button() {
   itemsPage.saveItemButton.click();
}
@Then("The Item is added to the Item list table")
public void the_item_is_added_to_the_item_list_table() throws InterruptedException {
	Thread.sleep(500);
	if (!utils.isElementPresent(itemsPage.filterNameBox)) {
		utils.waitUntilElementToBeClickable(itemsPage.filterButton);
		itemsPage.filterButton.click();
		utils.waitUntilElementVisible(itemsPage.filterNameBox);
		utils.actionsSendKeys(itemsPage.filterNameBox, itemName);
	}
	Thread.sleep(2000);
	Assert.assertTrue(
			Driver.getDriver().findElement(By.xpath("//a[text()='"+itemName+"']")).isDisplayed());
}
@When("I delete the item created above")
public void i_delete_the_item_created_above() throws InterruptedException {
   System.out.println(itemName);
   itemsPage.deleteAnItem(itemName);
  
}
@Then("The item is no longer in the items list table")
public void the_item_is_no_longer_in_the_items_list_table() throws InterruptedException {
	Thread.sleep(5000);
	if (!itemsPage.filterNameBox.isDisplayed()) {
		utils.waitUntilElementToBeClickable(itemsPage.filterButton);
		utils.actionsClick(itemsPage.filterButton);
		utils.waitUntilElementVisible(itemsPage.filterNameBox);
		utils.actionsSendKeys(itemsPage.filterNameBox, itemName);
	}
	utils.waitUntilElementVisible(itemsPage.filterNoResultFoundMessage);
	Assert.assertTrue(itemsPage.filterNoResultFoundMessage.isDisplayed());
}

}
