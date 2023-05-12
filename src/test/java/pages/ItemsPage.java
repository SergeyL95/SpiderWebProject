package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class ItemsPage {

	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//h3[text()='Items']")
	public WebElement itemsPageHeaderText;
	
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement itemsMenuNavigationPathHome;
	
	@FindBy(xpath = "//span[text()='/']")
	public WebElement itemsMenuNavigationPathforwardSlash;
	
	@FindBy(xpath = "//a[text()='Items']")
	public WebElement itemsMenuNavigationPathItems;

	@FindBy(xpath = "//button[text()=' Add Item']")
	public WebElement addItemButton;
	
	@FindBy(xpath = "//input[@variant='primary']")
	public WebElement itemsPageSelectAllPrimaryCheckBox;

	@FindBy(xpath = "//th[text()='Name ']")
	public WebElement itemsPageTableNameHeadingText;
	
	@FindBy(xpath = "//th[text()='Unit ']")
	public WebElement itemsPageTableUnitHeadingText;
	
	@FindBy(xpath = "//th[text()='Price ']")
	public WebElement itemsPageTablePriceHeadingText;
	
	@FindBy(xpath = "//input[@id='0']")
	public WebElement itemsPriceField;
	@FindBy(xpath = "//th[text()='Added On ']")
	public WebElement itemsPageAddedOnHeadingText;
	
	@FindBy(xpath = "//h3[text()='New Item']")
	public WebElement addItemPageHeaderText;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	public WebElement addItemName;

	@FindBy(xpath = "//div[text()='Price ']//parent::label//following-sibling::div/input")
	public WebElement addItemPrice;

	@FindBy(xpath = "//div[text()='select unit']//preceding::input[1]")
	public WebElement addItemUnit;

	@FindBy(xpath = "//span[text()='pc']")
	public WebElement addItem_pc_unit;
	
	@FindBy(xpath = "//span[text()='%s']")
	public WebElement unitOptions;

	@FindBy(name = "description")
	public WebElement addItemDesciption;

	@FindBy(xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;

	@FindBy(xpath = "//p[contains(text(), 'Success!')]")
	public WebElement successMsgAddItem;

	@FindBy(xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;

	@FindBy(xpath = "//button[text()=' Update Item']")
	public WebElement updateButton;
	
	@FindBy(xpath= "//button[text()='Filter ']")
	public WebElement filterButton;
	
	@FindBy (xpath = "//div[text()='Name ']")
	public WebElement filterNameBoxHeading;
	
	@FindBy (xpath = "//div[@name='name']")
	public WebElement filterNameInputField;
	
	@FindBy(xpath = "//div[text()='Unit ']")
	public WebElement filterUnitBoxHeading;
	
	@FindBy(xpath = "//div[text()='select unit']")
	public WebElement itemsPageUnitInputField;
	
	@FindBy(xpath = "//div[text()='Price ']")
	public WebElement filterPriceBoxHeadingField;
	
	@FindBy(xpath = "(//div[@class='flex flex-col mt-1'])[3]")
	public WebElement filterPriceInputField;
	
	@FindBy(xpath = "//label[text()='Clear All']")
	public WebElement filterClearAll;
	
	@FindBy(xpath = "//p[text()=' Showing   ']")
	public WebElement itemPageShowingPagesMsg;
	
	@FindBy(xpath = "//a[text()='%s']")
	public WebElement itemNameInTheItemsTable;
	
	@FindBy(xpath = "(//button[contains(@id, 'headlessui')])[3]")
	public WebElement filterItem3dot;
	
	@FindBy (xpath = "//a[text()=' Edit']")
	public WebElement filter3dotEditBtn;
	
	@FindBy (xpath = "//a[text()=' Delete']")
	public WebElement filter3dotDeleteBtn;
	
	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement itemDeleteOkayBtn;
	
	@FindBy (xpath = "//span[text()='No Results Found']")
	public WebElement filterNoResultFoundMessage;
	
	@FindBy (xpath = "//p[contains(@class, 'text-sm text-gray')]")
	public WebElement itemsPagePaginationText;
	
	@FindBy (xpath = "//span[text()='Next']")
	public WebElement itemPageRightPageNavigationBtn;
	
	@FindBy (xpath = "//span[text()='Previous']")
	public WebElement itemPageLeftPageNavigationBtn;
	
	@FindBy (xpath = "//a[text()='1']")
	public WebElement itemPageFirstPage;
	
	@FindBy (xpath = "//a[text()='2']")
	public WebElement itemPageSecondPage;
	
	@FindBy (xpath = "(//a[contains(@class, 'disabled')])[2]")
	public WebElement itemsFirstAndLastPageArrowDisabled;
	
	@FindBy (xpath = "//div[text()='Name ']")
	public WebElement addItemPageNameFieldText;
	
	@FindBy (xpath = "//div[text()='Price ']")
	public WebElement addItemPagePriceFieldText;
	
	@FindBy (xpath = "//div[text()='Unit ']")
	public WebElement addItemPageUnitFieldText;
	
	@FindBy (xpath = "//div[text()='Description ']")
	public WebElement addItemPageDescriptionFieldText;
	
	@FindBy (xpath = "//span[text()='Field is required']")
	public WebElement addItemPageFieldRequiredMsg;
	
	@FindBy (xpath = "//span[text()='Name must have at least 3 letters.']")
	public WebElement addItemPage3LettersRequiredMsg;
	
	


	
    BrowserUtils utils = new BrowserUtils();
	
	public void createAnItem(String itemName, String itemPrice, String itemUnit, String itemDes) {
		addItemName.sendKeys(itemName);
		addItemPrice.sendKeys(itemPrice);
		addItemUnit.click();
		utils.waitUntilElementVisible(addItem_pc_unit);
//		unitOptions.findElement(
//				By.xpath(String.format(unitOptions.getAttribute("xpath"), itemUnit))).click();
		Driver.getDriver().findElement(By.xpath("//span[text()='"+itemUnit+"']")).click();
		addItemDesciption.sendKeys(itemDes);
		saveItemButton.click();
	}
	
	
	public void deleteAnItem(String name) throws InterruptedException {
		filterButton.click();
		utils.waitUntilElementVisible(filterPriceInputField);
		utils.actionsSendKeys(filterPriceInputField, name);
//		itemNameInTheItemsTable.findElement(
//				By.xpath(String.format(itemNameInTheItemsTable.getAttribute("xpath"), name))).isDisplayed();
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='"+name+"']")).isDisplayed());
		utils.waitUntilElementVisible(filterItem3dot);
		Thread.sleep(2000);
		filterItem3dot.click();
		utils.waitUntilElementVisible(filter3dotDeleteBtn);
		filter3dotDeleteBtn.click();
		utils.waitUntilElementVisible(itemDeleteOkayBtn);
		itemDeleteOkayBtn.click();
	}
}
