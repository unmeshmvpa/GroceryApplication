package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	WaitUtility wu = new WaitUtility();
public WebDriver driver;
	
	@FindBy(name="username") WebElement userName;
	@FindBy(name="password") WebElement passWord;
	@FindBy(xpath="//button[@type='submit']") WebElement loginButton;
	@FindBy(xpath="//li[text()='Dashboard']") WebElement dashBoard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage enterUserNameOnUserNameField(String username) {
			userName.sendKeys(username);
			return this;
		}
		
	public LoginPage enterPasswordField(String password) {
		passWord.sendKeys(password);
		return this;
			}
	
	public HomePage clickLoginButton() {
		wu.waitUntilElementToBeClickable(driver, loginButton);
		loginButton.click();
		return new HomePage(driver);
		
	}
	public boolean verifywhetherDashBooardisDisplayed() {
		return dashBoard.isDisplayed();
	}
	public String verifyLoginTextIsDisplayed() {
		return text.getText();
	}

}
