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
import pages.LogInPage;
import pages.CustomersPage;
import utilities.BrowserUtils;
import utilities.Driver;

import org.json.JSONObject;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.DButils;
import utilities.DataReader;
import static io.restassured.RestAssured.given;
import java.util.List;

public class CustomersManagementSteps {
	CustomersPage customersPage=new CustomersPage();
	BrowserUtils utils=new BrowserUtils();
	LogInPage loginPage= new LogInPage();
	

	@Given("I navigate to Customers tab")
	public void i_navigate_to_customers_tab() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		loginPage.login();
		customersPage.customerTab.click();
	  
	}
	@Then("Validate I am on the Customers page \\(Header)")
	public void validate_i_am_on_the_customers_page_header() {
		utils.waitUntilElementVisible(customersPage.customersPageHeader);
		Assert.assertTrue(customersPage.customersPageHeader.isDisplayed());
	 
	}
	
	@Then("I should be able to see button titled Filter with a filter Icon")
	public void i_should_be_able_to_see_button_titled_filter_with_a_filter_icon() {
		utils.waitUntilElementVisible(customersPage.customerFilterButton);
		Assert.assertTrue(customersPage.customerFilterButton.isDisplayed());
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
	//@basicInfoValidation
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
	public void i_click_on_primary_currency_dropdown_i_should_be_able_to_see_different_curencies(Integer currencies) {
		/*WebElement dropDown=customersPage.currencyDropDownButton;
		dropDown.click();
		Select choose = new Select(dropDown);
		List<WebElement> allOptions=choose.getOptions();
		System.out.println(allOptions.size());*/
			//for(WebElement element: allOptions){
			//	System.out.println(element.getText());
			//}
	}
	@When("I leave the Display Name field empty, I should see Field is required message")
	public void i_leave_the_display_name_field_empty_i_should_see_field_is_required_message() {
	    customersPage.saveCustomerButton.click();
	    Assert.assertTrue(customersPage.fieldisRequiredErrorMessage.isDisplayed());
	}
	
	@When("the Email field does not follow \\(@domain.com) format, I should see Incorrect Email message")
	public void the_email_field_does_not_follow_domain_com_format_i_should_see_incorrect_email_message() {
	  utils.actionsSendKeys(customersPage.emailField, "testdomain.com");
	   customersPage.saveCustomerButton.click();
	   utils.waitUntilElementVisible(customersPage.incorrectEmailMessage);
	   Assert.assertTrue(customersPage.incorrectEmailMessage.isDisplayed());
		
	}
	
	@When("Website field is not correct format,I should see Invalid url error message")
	public void website_field_is_not_correct_format_i_should_see_invalid_url_ex_http_www_craterapp_com() {
	   utils.actionsSendKeys(customersPage.websiteField, "www.test.com");
	   customersPage.saveCustomerButton.click();
	   utils.waitUntilElementVisible(customersPage.websiteErrormessage);
	   Assert.assertTrue(customersPage.websiteErrormessage.isDisplayed());
	   customersPage.websiteField.clear();
	}
	@When("I provide Valid input for the required fields and click Save Customer button, I should be directed to Sales & Expenses page")
	public void i_provide_valid_input_for_the_required_fields_and_click_save_customer_button_i_should_be_directed_to_sales_expenses_page() {
	   utils.actionsSendMultipleKeys(customersPage.displayNameField, "Jack", customersPage.emailField, "jack@gmail.com",customersPage.websiteField,"http://jack.com");
	   customersPage.saveCustomerButton.click();
	//   utils.waitUntilElementVisible(customersPage.saleExpensesHeader);
	//   Assert.assertTrue(customersPage.saleExpensesHeader.isDisplayed());
	}
	


@When("I click on the Toggle Switch i should view a text box titled: “Customer Portal Login URL” and “http:\\/\\/invoice.primetech-apps.com\\/crater-invoice\\/customer\\/login “ Url")
public void i_click_on_the_toggle_switch_i_should_view_a_text_box_titled_customer_portal_login_url_and_http_invoice_primetech_apps_com_crater_invoice_customer_login_url() {
  customersPage.toggleSwitchButton.click();
  Assert.assertTrue(customersPage.customerPortalUrlHeader.isDisplayed());
  
  
}
@When("I click copy to clipboard button, I should see “Please copy & forward the above given URL to your customer for providing access.” message")
public void i_click_copy_to_clipboard_button_i_should_see_please_copy_forward_the_above_given_url_to_your_customer_for_providing_access_message() {
   Assert.assertTrue(customersPage.pleaseCopyMessage.isDisplayed());
   
}
@When("i should be able to see password and confirm password field")
public void i_should_be_able_to_see_password_and_confirm_password_field() {
  
	Assert.assertTrue(customersPage.passwordHeader.isDisplayed());
}
@When("I provide invalid data to password field,i should see Password must contain {int} characters error message")
public void i_provide_invalid_data_to_password_field_i_should_see_password_must_contain_characters_error_message(Integer int1) {
 utils.actionsSendKeys(customersPage.customerPasswordField, 1234567);
 Assert.assertTrue(customersPage.customerPasswordErrorMessage.isDisplayed());

	
}
@When("I provide different password to the confirm password field I should see Passwords must be identical: password {int} confirm password {int}")
public void i_provide_different_password_to_the_confirm_password_field_i_should_see_passwords_must_be_identical_password_confirm_password(Integer int1, Integer int2) throws InterruptedException {
  // customersPage.customerPasswordField.clear();
   utils.actionsSendKeys(customersPage.customerPasswordField,12345678);
   utils.waitUntilElementVisible(customersPage.customerConfirmPasswordField);
   utils.actionsSendKeys(customersPage.customerConfirmPasswordField, 1234567);
   Assert.assertTrue(customersPage.customerConfirmPassworderrormessage.isDisplayed());
   
}

@Then("I should be able to see Billing Address field")
public void i_should_be_able_to_see_billing_address_field() {
  Assert.assertTrue(customersPage.billingAddressHeader.isDisplayed());
}
@Then("I should be able to see following fields: Name, State, City, Country, Address Street1, Address Street2, Zipcode")
public void i_should_be_able_to_see_following_fields_name_state_city_country_address_street1_address_street2_zipcode() {
    
	   Assert.assertTrue(customersPage.billingNameField.isDisplayed());
	   Assert.assertTrue(customersPage.billingCountryField.isDisplayed());
	   Assert.assertTrue(customersPage.billingStateField.isDisplayed());
	   Assert.assertTrue(customersPage.billingCityField.isDisplayed());
	   Assert.assertTrue(customersPage.billingAddress1Field.isDisplayed());
	   Assert.assertTrue(customersPage.billingAddress2Field.isDisplayed());
	   Assert.assertTrue(customersPage.billingPhoneField.isDisplayed());
	   Assert.assertTrue(customersPage.billingZipcodeField.isDisplayed());
}

@Then("I should be able to see Shipping Address field")
public void i_should_be_able_to_see_shipping_address_field() {
   Assert.assertTrue(customersPage.shippingAddressHeaser.isDisplayed());
}
@Then("a button titled Copy from Billing")
public void a_button_titled_copy_from_billing() {
   Assert.assertTrue(customersPage.copyFromBillingButton.isDisplayed());
}

@When("I click on Filter Icon, I should be able to see Display Name, Contact Name, Phone and clear all link")
public void i_click_on_filter_icon_i_should_be_able_to_see_display_name_contact_name_phone_and_clear_all_link() {
  customersPage.customerFilterButton.click();
  Assert.assertTrue(customersPage.customerFilterDisplayNameHeader.isDisplayed());
  Assert.assertTrue(customersPage.customerFilterContactNameHeader.isDisplayed());
  Assert.assertTrue(customersPage.customerFilterPhoneHeader.isDisplayed());
  Assert.assertTrue(customersPage.customerFilterClearAll.isDisplayed());
}
@When("I type value in the contact name field, the matching result should return")
public void i_type_value_in_the_contact_name_field_the_matching_result_should_return() {
   
utils.actionsSendKeys(customersPage.customerFilterDisplayNameField, "customer1");
Assert.assertTrue(customersPage.filterResultByName.isDisplayed());
}
@When("I type value in the phone field,the matching result should return")
public void i_type_value_in_the_phone_field_the_matching_result_should_return() {
    utils.actionsSendKeys(customersPage.customerFilterPhoneField, 1234567890);
    Assert.assertTrue(customersPage.filterResultByPhone.isDisplayed());
}
@When("I type value in the contact name and phone field,the matching result should return")
public void i_type_value_in_the_contact_name_and_phone_field_the_matching_result_should_return() {
	utils.actionsSendKeys(customersPage.customerFilterDisplayNameField, "customer1");
	utils.actionsSendKeys(customersPage.customerFilterPhoneField, 1234567890);
	Assert.assertTrue(customersPage.filterResultByName.isDisplayed());
	 Assert.assertTrue(customersPage.filterResultByPhone.isDisplayed());
}
@When("I enter a value that is not exist in the database I should see the empty table with No Results Found message")
public void i_enter_a_value_that_is_not_exist_in_the_database_i_should_see_the_empty_table_with_no_results_found_message() {
	utils.actionsSendKeys(customersPage.customerFilterDisplayNameField, "customerX");
	Assert.assertTrue(customersPage.filterNoresultFoundMessage.isDisplayed());
}
@When("I click clear all, application will display current list of customer")
public void i_click_clear_all_application_will_display_current_list_of_customer() {
   customersPage.customerFilterClearAll.click();
   Assert.assertTrue(customersPage.nameColumn.isDisplayed());
}
@When("I click on Filter Icon again, I should be able to see Display Name, Contact Name, Phone and clear all link")
public void i_click_on_filter_icon_again_i_should_be_able_to_see_display_name_contact_name_phone_and_clear_all_link() {
   customersPage.customerFilterButton.click();
   Assert.assertTrue(customersPage.customerFilterDisplayNameHeader.isDisplayed());
   Assert.assertTrue(customersPage.customerFilterContactNameHeader.isDisplayed());
   Assert.assertTrue(customersPage.customerFilterPhoneHeader.isDisplayed());
   Assert.assertTrue(customersPage.customerFilterClearAll.isDisplayed());
}
}