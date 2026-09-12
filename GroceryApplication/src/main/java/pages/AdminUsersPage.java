package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	PageUtility pu = new PageUtility();
	public WebDriver driver;
	@FindBy(xpath="//a[text()=' New']") WebElement addNewUser;
	@FindBy(xpath="//input[@id='username']") WebElement userName;
	@FindBy(xpath="//input[@id='password']") WebElement passWord;
	@FindBy(xpath="//select[@id='user_type']") WebElement userType;
	@FindBy(xpath="//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
	@FindBy(xpath="//a[text()=' Search']") WebElement searchUser;
	@FindBy(xpath="//input[@id='un']") WebElement usrName;
	@FindBy(xpath="//select[@id='ut']") WebElement searchUserType;
	@FindBy(xpath="//button[@value='sr']") WebElement searchButton;
//	@FindBy(xpath="//h4[text()='Admin Users']") WebElement searchUsersHeading;
	@FindBy(xpath="//h4[text()='Admin Users']") WebElement searchTable;
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage addNewAdminUser() {
		addNewUser.click();
		return this;
	}
	public AdminUsersPage createNewAdminUser(String username,String password, String usertp) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		Select adminUserType = new Select(userType);
		adminUserType.selectByVisibleText(usertp);
		saveButton.click();
		return this;
	}
	public String checkingAlertMsg() {
		String alertMsg = alert.getText();
		System.out.println(alertMsg);
		return alertMsg;
		
	}
	public AdminUsersPage searchUsers(String usrNamesearch, String usrTypesearch) {
		pu.selectDropdownWithVisibleText(searchUserType,"usrTypesearch");
		searchUser.click();
		usrName.sendKeys(usrNamesearch);
	//	Select usrType = new Select(searchUserType);
	//	usrType.selectByVisibleText(usrTypesearch);
		searchButton.click();
		return this;
		
	}
	public boolean isSearchResultTableVisible() {
		boolean searchResultTable = searchTable.isDisplayed();
		return searchResultTable;
	}

}
