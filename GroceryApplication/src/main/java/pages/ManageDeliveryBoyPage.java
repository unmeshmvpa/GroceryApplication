package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
			}
	
	@FindBy(xpath="//a[text()=' New']") WebElement addNewDelBoy;
	@FindBy(xpath="//input[@id='name']") WebElement boyName;
	@FindBy(xpath="//input[@id='email']") WebElement boyEmail;
	@FindBy(xpath="//input[@id='phone']") WebElement boyPhone;
	@FindBy(xpath="//textarea[@id='address']") WebElement boyAddress;
	@FindBy(xpath="//input[@id='username']") WebElement boyUsername;
	@FindBy(xpath="//input[@id='password']") WebElement boyPassword;
	@FindBy(xpath="//button[@class='btn btn-danger']") WebElement saveDBbutton;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
//	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successText;
	public void addNewDeliveryBoy() {
		addNewDelBoy.click();
	}
	
	public void enterDeliveryBoyName(String delBoyName) {
		boyName.sendKeys(delBoyName);
		
	}
	public void enterDeliveryBoyEmail(String delBoyEmail) {
		boyEmail.sendKeys(delBoyEmail);
	}
	public void enterDeliveryBoyPhone(String delBoyPhone) {
		boyPhone.sendKeys(delBoyPhone);
	}
	public void enterDeliveryBoyAddress(String delBoyAddress) {
		boyAddress.sendKeys(delBoyAddress);
	}
	public void enterDeliveryBoyUsername(String delBoyUsername) {
		boyUsername.sendKeys(delBoyUsername);
	}
	public void enterDelBoyPassword(String delBoyPassword) {
		boyPassword.sendKeys(delBoyPassword);
	}

	public void saveNewDeliveryBoy(WebDriver driver) { 
		Actions actions = new Actions(driver);
				actions.click(saveDBbutton).perform();
	}
	
	public String checkingAlertMsg() {
		String alertMsg = alert.getText();
		return alertMsg;
	}
}
