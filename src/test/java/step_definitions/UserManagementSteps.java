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
	
	// valid log scenario steps
	
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
	   Driver.getDriver().get(DataReader.getProperty("appUrl"));
	}
	@When("I enter valid username and valid password")
	public void i_enter_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginpage.passwordField, DataReader.getProperty("password"));
//		loginpage.emailField.sendKeys(DataReader.getProperty("username"));
//		loginpage.passwordField.sendKeys(DataReader.getProperty("password"));
	}
	@When("I click on login button")
	public void i_click_on_login_button() {
		loginpage.loginBtn.click();
	}
	@Then("I should be on user profile page")
	public void i_should_be_on_user_profile_page() {
		Assert.assertTrue(loginpage.accountSettingsHeader.isDisplayed());
	}
	
}
