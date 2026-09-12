package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base{
	HomePage hp;
	AdminUsersPage admnPage;
	@Test(description="To varify whether the user is able to create new admin user")
	public void verifyWhetherUserIsAbledToAddNewAdminUser() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
//		AdminUsersPage admnPage = new AdminUsersPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue);
	//	lp.clickLoginButton()
		hp = lp.clickLoginButton();
		admnPage=hp.adminMoreinfo();
		
		admnPage.addNewAdminUser();
		RandomDataUtility rd = new RandomDataUtility();
		String adminUsr = rd.generateRandomUsername();
		String adminpwd = rd.generateRandomPassword();
		String admintype = ExcelUtility.readStringData(0, 2, "AdminUsers");
		admnPage.createNewAdminUser(adminUsr, adminpwd, admintype);
		String actual = "Alert!";
		String expected = admnPage.checkingAlertMsg();
		Assert.assertEquals(actual,expected,Constant.NEWADMINUSERCREATIONERROR);

		
	}
	@Test(description="To varify whether the user is able to search newly added admin user")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		AdminUsersPage admnPage = new AdminUsersPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue).enterPasswordField(passwordValue);
//		lp.clickLoginButton();
		hp = lp.clickLoginButton();
		admnPage=hp.adminMoreinfo();
		String admnUsr = ExcelUtility.readStringData(0, 0, "AdminUsers");
		String admnType = ExcelUtility.readStringData(0, 2, "AdminUsers");
		admnPage.searchUsers(admnUsr, admnType);
		boolean isTableDisplayed =admnPage.isSearchResultTableVisible();
		Assert.assertTrue(isTableDisplayed, Constant.NEWADMINUSERSEARCHERROR);
		
	}

}
