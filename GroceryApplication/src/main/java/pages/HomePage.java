package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	@FindBy(xpath="//img[@class='img-circle']") WebElement adminButton;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement logoutButton;
	@FindBy(xpath="(//a[text()='More info '])[2]") WebElement adminList;
	@FindBy(xpath="(//a[text()='More info '])[8]") WebElement deliveryBoyMoreinfo;
	@FindBy(xpath="(//a[text()='More info '])[13]") WebElement manageNews;
	@FindBy(xpath="//h1[text()='Admin Users']") WebElement adminPageHeading;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage logOut() {
	    adminButton.click();
		logoutButton.click();
		return new LoginPage(driver);

	}	
	public AdminUsersPage adminMoreinfo() {
		adminList.click();
		return new AdminUsersPage(driver);
	}
	public String verifyAdminPageHeading() {
		return adminPageHeading.getText();
	}
	public ManageDeliveryBoyPage manageDeliveryBoyMoreinfo() {
		deliveryBoyMoreinfo.click();
		return new  ManageDeliveryBoyPage(driver);
	}
	public ManageNewsPage manageNewsinfo(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.click(manageNews).perform();
		return new ManageNewsPage(driver);
	}
}
