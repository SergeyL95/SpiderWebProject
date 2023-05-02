package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogInPage;
import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class UserManagementSteps {

	LogInPage loginpage = new LogInPage();
	BrowserUtils utils = new BrowserUtils();
	
	String emailAddress;
	String passwordInput;
	
	// FORGOT PASSWORD LINK
	
	@Given("I am crater user, I navigate to the Login screen")
	public void i_am_crater_user_i_navigate_to_the_login_screen() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
	    
	}
	@When("I click on the Forget Password? Link")
	public void i_click_on_the_forget_password_link() {
	    loginpage.forgotPassword.click();
	}
	@Then("I should be directed to a new page")
	public void i_should_be_directed_to_a_new_page() {
	    String windowHandle = Driver.getDriver().getWindowHandle();
	    Driver.getDriver().switchTo().window(windowHandle);
	}
	@Then("I should see text box titled Enter email, Send Reset Link, Back to Login")
	public void i_should_see_text_box_titled_enter_email_send_reset_link_back_to_login() {
	    loginpage.enterEmail.isDisplayed();
	    loginpage.sendResetLinkButton.isDisplayed();
	    loginpage.backToLoginLink.isDisplayed();
	}
	
	//RESET PASSWORD
	
	@When("I enter a value for the email value")
	public void i_enter_a_value_for_the_email_value() {
	    utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("forgotUsername"));
	}
	@Then("click on the Send Reset Link")
	public void click_on_the_send_reset_link() {
	    loginpage.sendResetLinkButton.click();
	}
	@Then("I navigate to my gmail")
	public void i_navigate_to_my_gmail() {
	    Driver.getDriver().get(DataReader.getProperty("gmailUrl"));
	}
	@Then("I enter username and password")
	public void i_enter_username_and_password() throws InterruptedException {
		Driver.getDriver().get(DataReader.getProperty("gmailUrl"));
		Thread.sleep(1000);
		utils.waitUntilElementToBeClickable(loginpage.gmailEmailToLogin);
		Thread.sleep(500);
		utils.actionsSendKeys(loginpage.gmailEmailToLogin, DataReader.getProperty("gmailUsername"));
		loginpage.gmailLoginNextButton.click();
		Thread.sleep(1000);
		utils.waitUntilElementToBeClickable(loginpage.gmailPasswdToLogin);
		utils.actionsSendKeys(loginpage.gmailPasswdToLogin, DataReader.getProperty("gmailPassword"));
		loginpage.gmailLoginNextButton.click();
		utils.waitUntilElementVisible(loginpage.resetPasswordNotificationOnGmail);
		Assert.assertTrue(loginpage.resetPasswordNotificationOnGmail.isDisplayed());
	}
	
	// INVALID RESET PASSWORD
	
	@Given("I enter invalid value for the {string} value amd enter email in the incorrect format {string}")
	public void i_enter_invalid_value_for_the_value_amd_enter_email_in_the_incorrect_format(String incorrectEmail, String incorrectFormat) {
	    loginpage.emailField.sendKeys(incorrectEmail, incorrectFormat);
	}
	@Then("I should see error message Incorrect Email")
	public void i_should_see_error_message_incorrect_email() {
		loginpage.incorrectEmailErrorMsg.isDisplayed();
	}
	@Then("If I leave email field {string}")
	public void if_i_leave_email_field(String string) {
	    loginpage.emailField.sendKeys(string);
	}
	@Then("I should see error message Field is required")
	public void i_should_see_error_message_field_is_required() {
		Assert.assertTrue(loginpage.fieldIsRequiredErrorMsg.isDisplayed());
	}
	
	//RESET PASSWORD VIA EMAIL
	
	@Then("I enter valid Email")
	public void i_enter_valid_email() {
		utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("forgotUsername"));
	}
	@Then("I click on Send Reset Link")
	public void i_click_on_send_reset_link() {
	    loginpage.sendResetLinkButton.click();
	}
	@Then("I click on the Reset Password link in the email i received")
	public void i_click_on_the_reset_password_link_in_the_email_i_received() {
	   
	}
	@Then("I should be directed to a new page with Email, Password, Retype Password")
	public void i_should_be_directed_to_a_new_page_with_email_password_retype_password() {
	    
	}
	@Then("i enter valid {string} {string} and {string}")
	public void i_enter_valid_and(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	    
	}
	@Then("If i validation passed, i should be able to reset my account password")
	public void if_i_validation_passed_i_should_be_able_to_reset_my_account_password() {
	    
	}
	@Then("directed to the login page")
	public void directed_to_the_login_page() {
	    
	}
	
	// INVALID RESET PASSWORD VIA EMAIL
	
	@Then("i enter invalid {string} {string} and {string} and i should see error message")
	public void i_enter_invalid_and_and_i_should_see_error_message(String string, String string2, String string3, io.cucumber.datatable.DataTable dataTable) {
	    
	}
	
	
}
