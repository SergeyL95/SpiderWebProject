package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class CustomersPage {

	public CustomersPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (xpath="//a[text()=' Customers']")
	public WebElement customerTab;
	
	@FindBy (xpath="//h3[text()='Customers']")
	public WebElement customersPageHeader;
	
	@FindBy (xpath="//button[text()='Filter ']")
	public WebElement customerFilterButton;
	
	@FindBy (xpath="//button[text()=' New Customer']")
	public WebElement addNewCustomerButton;
	
	@FindBy (xpath="//input[contains(@id,'check')]")
	public WebElement selectAllCheckBox;
	
	@FindBy (xpath="//th[text()='Name ']")
	public WebElement nameColumn;
	
	@FindBy (xpath="//th[text()='Phone ']")
	public WebElement phoneColumn;
	
	@FindBy (xpath="//th[text()='Amount Due ']")
	public WebElement amountDueColumn;
	
	
	@FindBy (xpath="//th[text()='Added On ']")
	public WebElement addedOnColumn;
	

	@FindBy (id="headlessui-menu-button-5")
	public WebElement ThreeDotButton;
	
	@FindBy (xpath="//a[text()=' Edit']")
	public WebElement customerEditButton;
	
	@FindBy (xpath="//a[text()=' View']")
	public WebElement customerViewButton;
	
	@FindBy (xpath="//a[text()=' Delete']")
	public WebElement customerDeleteButton;
	
	@FindBy (xpath="//span[text()='Previous']/parent::a")
	public WebElement leftNavigationArrow ;
	
	@FindBy (xpath="//span[text()='Next']/parent::a")
	public WebElement rightNavigationArrow;
	
	@FindBy (xpath="//a[text()=' 1 ']")
	public WebElement pageNumerOne;
	
	@FindBy (xpath="//a[text()='2']")
	public WebElement pageNumberTwo;
	
	@FindBy (xpath="//a[text()='3']")
	public WebElement lastPageNumber;
	
	@FindBy (xpath="//h3[text()='New Customer']")
	public WebElement newCustomerPageHeader;
	
	@FindBy (xpath="//h6[text()='Basic Info']")
	public WebElement basicInfoText;
	
	@FindBy (xpath="//div[text()='USD - US Dollar']/following::span[1]")
	public WebElement currencyDropDownButton;
	
	@FindBy (xpath="//span[text()='Field is required']")
    public WebElement fieldisRequiredErrorMessage;
	
	@FindBy (xpath="//button[text()=' Save Customer']")
	public WebElement saveCustomerButton;
	
	@FindBy (xpath="//span[text()='Name must have at least 3 letters.']")
	public WebElement invalidNameFieldMessage;
	
	@FindBy (name="name")
	public WebElement displayNameField;
	
	@FindBy (name="email")
	public WebElement emailField;
	
	@FindBy (xpath="//span[text()='Incorrect Email.']")
	public WebElement incorrectEmailMessage;
	
	@FindBy (xpath="//input[@type='url']")
	public WebElement websiteField;
	
	@FindBy (xpath="//span[text()='Invalid url (ex: http://www.craterapp.com)']")
	public WebElement websiteErrormessage;
	
	@FindBy (xpath="//h6[@class='flex items-center']")
	public WebElement saleExpensesHeader;
	
	@FindBy (xpath="//button[contains(@id,'headlessui-switch')]")
	public WebElement toggleSwitchButton;
	
	@FindBy (xpath="//div[text()='Customer Portal Login URL ']")
	public WebElement customerPortalUrlHeader;
	
	@FindBy (xpath="//span[contains(text(),'Please copy')]")
	public WebElement pleaseCopyMessage;
	
	@FindBy (xpath="//div[text()='Password ']")
	public WebElement passwordHeader;
	
	@FindBy (xpath="//div[text()='Confirm Password ']")
	public WebElement confirmPasswordHeader;
	
	@FindBy (name="password")
	public WebElement customerPasswordField;
	
	@FindBy (name="confirm_password")
	public WebElement customerConfirmPasswordField;
	
	@FindBy (xpath="//span[text()='Password must contain 8 characters']")
	public WebElement customerPasswordErrorMessage;
	
	@FindBy (xpath="//span[text()='Passwords must be identical']")
	public WebElement customerConfirmPassworderrormessage;
	
	@FindBy (xpath="//h6[text()='Billing Address']")
	public WebElement billingAddressHeader;
	
	@FindBy (xpath="(//input[@name='address_name'])[1]")
	public WebElement billingNameField;
	
	@FindBy (xpath="(//input[@type='text'])[9]")
	public WebElement billingCountryField;
	
	@FindBy (xpath="//input[@name='billing.state']")
	public WebElement billingStateField;
	
	@FindBy (xpath="//input[@name='billing.city']")
	public WebElement billingCityField;
	
	@FindBy (xpath="//textarea[@name='billing_street1']")
	public WebElement billingAddress1Field;
	
	@FindBy (xpath="//textarea[@name='billing_street2']")
	public WebElement billingAddress2Field;
	
	@FindBy (xpath="(//input[@name='phone'])[2]")
	public WebElement billingPhoneField;
	
	@FindBy (xpath="(//input[@name='zip'])[1]")
	public WebElement billingZipcodeField;
	
	@FindBy (xpath="//h6[text()='Shipping Address']")
	public WebElement shippingAddressHeaser;
	
	@FindBy (xpath="//button[text()=' Copy from Billing']")
	public WebElement copyFromBillingButton;
	
	@FindBy (xpath="//div[text()='Display Name ']")
	public WebElement customerFilterDisplayNameHeader;
	
	
	@FindBy (xpath="//div[text()='Contact Name ']")
	public WebElement customerFilterContactNameHeader;
	
	@FindBy (xpath="//div[text()='Phone ']")
	public WebElement customerFilterPhoneHeader;
	
	@FindBy (xpath="//label[text()='Clear All']")
	public WebElement customerFilterClearAll;
	
	@FindBy (xpath="//input[@name='name']")
	public WebElement customerFilterDisplayNameField;
	
	@FindBy (xpath="//input[@name='phone']")
	public WebElement customerFilterPhoneField;
	
	@FindBy (xpath="//span[@title='customer1']")
	public WebElement filterResultByName;
	
	@FindBy (xpath="//span[text()='1234567890']")
	public WebElement filterResultByPhone;
	
	@FindBy (xpath="//span[text()='No Results Found']")
	public WebElement filterNoresultFoundMessage;
	
}
