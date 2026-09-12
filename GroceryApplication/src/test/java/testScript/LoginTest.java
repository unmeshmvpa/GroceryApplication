package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage home;

	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void varifyUserLoginWithValidCredentials() throws IOException {

		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue);
		home=lp.clickLoginButton();
		boolean dashBoardValue = lp.verifywhetherDashBooardisDisplayed();
		Assert.assertTrue(dashBoardValue,Constant.VALIDCREDENTIALERROR);

	}

	@Test(priority = 4, description = "User is trying to login with invalid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);

	}

	@Test(priority = 2, description = "User is trying to login with valid username and invalid password")
	public void verifyLoginWithInvalidPassword() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);
	}

	@Test(priority = 3, description = "User is trying to login with invalid username and valid password", groups = {
			"smoke" }, dataProvider="LoginData")
	public void verifyUserLoginWithInvalidUserName(String userNameValue, String passwordValue) throws IOException {
		LoginPage lp = new LoginPage(driver);
		//String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue).clickLoginButton();
		String actual = lp.verifyLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEERROR);

	}

	@DataProvider(name = "LoginData")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "admin123" } };
	}
}
