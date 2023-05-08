package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;
import utilities.DataReader;
import utilities.Driver;

public class LoginUIPage {
	
	LogInPage loginpage = new LogInPage();
	
	@Given("I am crater user, I navigate to the “Prime Tech Invoice Application” login page")
	public void i_am_crater_user_i_navigate_to_the_prime_tech_invoice_application_login_page() {
		Driver.getDriver().get(DataReader.getProperty("loginURL"));
	}
	@Given("Page title crater")
	public void page_title_crater() {
	    loginpage.textCraterOnTheLoginPage.isDisplayed();
	}

	@Given("text box with label {string} and text box with label {string}")
	public void text_box_with_label_and_text_box_with_label(String emailField, String passwordField) {
		Assert.assertEquals(emailField, loginpage.emailField.isDisplayed());
		Assert.assertEquals(passwordField, loginpage.passwordField.isDisplayed());
		//loginpage.emailField.isDisplayed();
		//loginpage.passwordField.isDisplayed();
	}

	@Given("a link titled forgot password? exist")
	public void a_link_titled_forgot_password_exist() {
	    loginpage.forgotPassword.isDisplayed();
	}

	@Given("a primary button labeled {string}")
	public void a_primary_button_labeled(String string) {
	    loginpage.loginBtn.isDisplayed();
	}

	@Given("a text area with the following {string} located on the bottom left")
	public void a_text_area_with_the_following_located_on_the_bottom_left(String string) {
	   loginpage.textCopyright.isDisplayed();
	}

	@Given("a heading with following text {string} exist")
	public void a_heading_with_following_text_exist(String string) {
	    loginpage.textBussiness.isDisplayed();
	}

	@Given("I enter a valid email and password value")
	public void i_enter_a_valid_email_and_password_value() {
	    
	}

	@Given("I click on the login button")
	public void i_click_on_the_login_button() {
	    
	}

	@Then("The system should validate that the username and password combination matches an existing user record in the application database.")
	public void the_system_should_validate_that_the_username_and_password_combination_matches_an_existing_user_record_in_the_application_database() {
	    
	}

	@Then("Upon successful login the system should direct the user to the Dashboard page.")
	public void upon_successful_login_the_system_should_direct_the_user_to_the_dashboard_page() {
		Assert.assertTrue(loginpage.accountSettingsHeader.isDisplayed());
	}

	@Given("I enter an invalid email and password value,")
	public void i_enter_an_invalid_emailand_password_value() {
	    
	}

	@Then("System should prompt the user with a flash message in a red box with the following text Error Those credentials do not match our records")
	public void system_should_prompt_the_user_with_a_flash_message_in_a_red_box_with_the_following_text_error_those_credentials_do_not_match_our_records() {
	    
	}

	@Then("Flash message should have a close button to the right and should disappear from the user’s view in less than or equal to {int} seconds.")
	public void flash_message_should_have_a_close_button_to_the_right_and_should_disappear_from_the_user_s_view_in_less_than_or_equal_to_seconds(Integer int1) {
	    
	}

	@Given("I leave the email and password field empty")
	public void i_leave_the_email_and_password_field_empty() {
	    
	}

	@Given("I leave the just email field empty")
	public void i_leave_the_just_email_field_empty() {
	   
	}

	@Given("I leave the just password field empty")
	public void i_leave_the_just_password_field_empty() {
	    
	}

	@Then("System should prompt the user with the following inline message for the respective scenarios")
	public void system_should_prompt_the_user_with_the_following_inline_message_for_the_respective_scenarios() {
	   
	}

	@When("email is required error should appear when a user leaves email is blank")
	public void email_is_required_error_should_appear_when_a_user_leaves_email_is_blank() {
	   
	}

	@When("password is required error should appear when a user leaves password is blank")
	public void password_is_required_error_should_appear_when_a_user_leaves_password_is_blank() {
	    
		
	}

}
