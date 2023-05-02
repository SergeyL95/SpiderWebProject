package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CustomersPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class CustomersManagementSteps {
	
	CustomersPage customersPage=new CustomersPage();
	BrowserUtils utils=new BrowserUtils();
	

	@Given("I navigate to Customers tab")
	public void i_navigate_to_customers_tab() {
		
		customersPage.customerTab.click();
	  
	}
	@Then("Validate I am on the Customers page \\(Header)")
	public void validate_i_am_on_the_customers_page_header() {
		utils.waitUntilElementVisible(customersPage.customersPageHeader);
		Assert.assertTrue(customersPage.customersPageHeader.isDisplayed());
	 
	}
	@Then("I should be able to see button titled filter")
	public void i_should_be_able_to_see_button_titled_filter() {
		utils.waitUntilElementVisible(customersPage.filterButton);
		Assert.assertTrue(customersPage.filterButton.isDisplayed());
		  
	}
	@Then("I should be able to see a primary button titled + New Customer")
	public void i_should_be_able_to_see_a_primary_button_titled_new_customer() {
	  Assert.assertTrue(customersPage.addNewCustomerButton.isDisplayed());
	}
	@Then("I should be able to see these columns: Select All checkbox, Name,Phone,Amount Due, Added On")
	public void i_should_be_able_to_see_these_columns_select_all_checkbox_name_phone_amount_due_added_on() {
	
		Assert.assertTrue(customersPage.selectAllCheckBox.isDisplayed());
		Assert.assertTrue(customersPage.nameColumn.isDisplayed());
		Assert.assertTrue(customersPage.phoneColumn.isDisplayed());
		Assert.assertTrue(customersPage.amountDueColumn.isDisplayed());
		Assert.assertTrue(customersPage.addedOnColumn.isDisplayed());
	}
	@Then("I should be able to see A link icon showing three dots with the following options:edit, view, delete")
	public void i_should_be_able_to_see_a_link_icon_showing_three_dots_with_the_following_options_edit_view_delete() {
	   
		customersPage.ThreeDotButton.click();
		utils.waitUntilElementVisible(customersPage.customerEditButton);
		Assert.assertTrue(customersPage.customerEditButton.isDisplayed());
		Assert.assertTrue(customersPage.customerViewButton.isDisplayed());
		Assert.assertTrue(customersPage.customerDeleteButton.isDisplayed());
	}
	
	@Then("I should be able to see Pagination navigation with left and right controls")
	public void i_should_be_able_to_see_pagination_navigation_with_left_and_right_controls() {
	  Assert.assertTrue(customersPage.leftNavigationArrow.isDisplayed());
	  Assert.assertTrue(customersPage.rightNavigationArrow.isDisplayed());
		
	}
	@When("I click on right arrow")
	public void i_click_on_right_arrow() {
		
		utils.scrollToElement(customersPage.rightNavigationArrow);
		utils.waitUntilElementVisible(customersPage.rightNavigationArrow);
		customersPage.rightNavigationArrow.click();
	   
	}
	@Then("I should be able to nevegate to the next page")
	public void i_should_be_able_to_nevegate_to_the_next_page() {
		utils.waitUntilElementVisible(customersPage.pageNumberTwo);
	  Assert.assertTrue(customersPage.pageNumberTwo.isDisplayed());
	}
	@When("I click on left arrow")
	public void i_click_on_left_arrow() {
		utils.scrollToElement(customersPage.leftNavigationArrow);
		utils.waitUntilElementVisible(customersPage.leftNavigationArrow);
	    customersPage.leftNavigationArrow.click();
	}
	@Then("I should be able to nevegate to the previous page")
	public void i_should_be_able_to_nevegate_to_the_previous_page() {
	    utils.waitUntilElementVisible(customersPage.pageNumerOne);
	    Assert.assertTrue(customersPage.pageNumerOne.isDisplayed());
	}
	@When("I am on the first page, left arrow should be disabled")
	public void i_am_on_the_first_page_left_arrow_should_be_disabled() {
		if(customersPage.leftNavigationArrow.getAttribute("class").contains("disabled")) {
			System.out.println("left arrow is disabled");
		}else {
			System.out.println("left arrow is not disabled");
		}
	}
	@When("I am on the last page, right arrow should be disabled")
	public void i_am_on_the_last_page_right_arrow_should_be_disabled() {
		
		customersPage.lastPageNumber.click();
		if(customersPage.rightNavigationArrow.getAttribute("class").contains("disabled")) {
			System.out.println("right arrow is disabled");
		}else {
			System.out.println("right arrow is not disabled");
			
		}
	}

@When("I click +New Customer botton, I should directed to New Customer Page")
public void i_click_new_customer_botton_i_should_directed_to_new_customer_page() {
    customersPage.addNewCustomerButton.click();
    utils.waitUntilElementVisible(customersPage.newCustomerPageHeader);
    Assert.assertTrue(customersPage.newCustomerPageHeader.isDisplayed());
    
}
@When("I should be able to see basic info field")
public void i_should_be_able_to_see_basic_info_field() {
  Assert.assertTrue(customersPage.basicInfoText.isDisplayed());
}
@When("I click on Primary Currency dropdown, I should be able to see {int} different curencies")
public void i_click_on_primary_currency_dropdown_i_should_be_able_to_see_different_curencies(Integer int1) {
	WebElement dropDown=customersPage.currencyDropDownButton;
	dropDown.click();
	utils.waitUntilElementVisible(customersPage.currencyDropDownButton);
	Select choose = new Select(dropDown);
	List<WebElement> allOptions=choose.getOptions();
	System.out.println(allOptions.size());
		//for(WebElement element: allOptions){
		//	System.out.println(element.getText());
		//}
}
@When("I leave the Display Name field empty, I should see Field is required message")
public void i_leave_the_display_name_field_empty_i_should_see_field_is_required_message() {
    
}
@When("I input less the three character for the Dispay Name field,I should be able to see Name must have at least {int} letters message")
public void i_input_less_the_three_character_for_the_dispay_name_field_i_should_be_able_to_see_name_must_have_at_least_letters_message(Integer int1) {

}
@When("the Email field does not follow \\(@domain.com) format, I should see Incorrect Email message")
public void the_email_field_does_not_follow_domain_com_format_i_should_see_incorrect_email_message() {
   
}
@When("I input less the three character for the Prefix field,I should be able to see Name must have at least {int} letters message")
public void i_input_less_the_three_character_for_the_prefix_field_i_should_be_able_to_see_name_must_have_at_least_letters_message(Integer int1) {
 
}
@When("Website field is not correct format,I should see Invalid url error message")
public void website_field_is_not_correct_format_i_should_see_invalid_url_ex_http_www_craterapp_com() {
   
}
@When("I provide Valid input for the required fields and click Save Customer button, I should be directed to Sales & Expenses page")
public void i_provide_valid_input_for_the_required_fields_and_click_save_customer_button_i_should_be_directed_to_sales_expenses_page() {
   
}

}
