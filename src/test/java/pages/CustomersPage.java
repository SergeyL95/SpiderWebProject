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
	public WebElement filterButton;
	
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
	
}
