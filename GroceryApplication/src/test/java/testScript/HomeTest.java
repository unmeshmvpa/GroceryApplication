package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class HomeTest extends Base {
	HomePage hp;
	@Test(description="To varify whether the user is able to logout successfully")
	public void varifyWhetherUserIsAbleToSuccessfullyLoggedOut() throws IOException {
		LoginPage lp = new LoginPage(driver);
		
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue);
		hp=lp.clickLoginButton();

		lp=hp.logOut();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.ADMINUSERLOGOUTERROR);
		
	}
	@Test(description ="To load admin user more info page")
	public void adminMoreinfo() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue);
		lp.enterPasswordField(passwordValue);
		lp.clickLoginButton();

		hp.adminMoreinfo();
		String actual = hp.verifyAdminPageHeading();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected,Constant.ADMINUSERPAGELOADERROR);
		
		
	}

}
