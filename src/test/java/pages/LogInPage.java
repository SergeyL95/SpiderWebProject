package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.DataReader;
import utilities.Driver;

public class LogInPage {
	
	public LogInPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	BrowserUtils utils = new BrowserUtils();
	
	@FindBy (name = "email")
	public WebElement emailField;
	
	@FindBy (name = "password")
	public WebElement passwordField;
	
	@FindBy (xpath = "//button[text()='Login']")
	public WebElement loginBtn;
	
	@FindBy (xpath = "//h6[text()='Account Settings']")
	public WebElement accountSettingsHeader;
	
	@FindBy (xpath = "//p[text()='These credentials do not match our records.']")
	public WebElement invalidLoginErrorMessage;
	
	@FindBy (xpath = "//span[text()='Field is required']")
	public WebElement fieldIsRequiredMessage;
	
	@FindBy (xpath = "//a[text()='Forgot Password?']")
	public WebElement forgotPassword;
	
	@FindBy (xpath = "//div[text()='Enter email ']")
	public WebElement enterEmail;
	
	@FindBy (xpath = "//div[text()='Send Reset Link']")
	public WebElement sendResetLinkButton;
	
	@FindBy (xpath = "//a[text()='Back to Login?']")
	public WebElement backToLoginLink;
	
	@FindBy (xpath = "//span[text()='Incorrect Email.']")
	public WebElement incorrectEmailErrorMsg;
	
	@FindBy (xpath = "//span[text()='Field is required']")
	public WebElement fieldIsRequiredErrorMsg;
	
	@FindBy (xpath = "//a[text()='Sign in']")
	public WebElement gmailSignInButton;
	
	@FindBy (xpath = "//input[@id='identifierId']")
	public WebElement gmailEmailToLogin;
	
	@FindBy (xpath = "//span[text()='Next']")
	public WebElement gmailLoginNextButton;
	
	@FindBy (xpath = "//input[@name='Passwd']")
	public WebElement gmailPasswdToLogin;
	
	@FindBy (xpath = "//tr[@class='zA yO x7']")
	public WebElement resetPasswordNotificationOnGmail;
	
	
	
	
	public void login() {
		utils.actionsSendKeys(emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(passwordField, DataReader.getProperty("password"));
		loginBtn.click();
	}
}
