package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description="To verify whether the user is able to add new news")
	public void  verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ManageNewsPage mnp = new ManageNewsPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue);
		lp.enterPasswordField(passwordValue);
		lp.clickLoginButton();
		hp.manageNewsinfo(driver);
		mnp.addNews();
		String news =  ExcelUtility.readStringData(0, 0, "News");
		mnp.addNewNews(news);
		String actual = "Alert!";
		String expected = mnp.assertaionAddNewNews();
		Assert.assertEquals(actual,expected,Constant.ADDNEWNEWSERROR);
	
	}
	@Test(description="To verify whether the user is able to search news")
	public void verifyWhetherUserIsAbleToSearchNews() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ManageNewsPage mnp = new ManageNewsPage(driver);
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue);
		lp.enterPasswordField(passwordValue);
		lp.clickLoginButton();
		hp.manageNewsinfo(driver);
		mnp.initiateSearch();
		String news =  ExcelUtility.readStringData(0, 0, "News");
		mnp.searchNews(news);
		String actual = "Manage News";
	    String expected = mnp.assertationSearchNews();
		Assert.assertEquals(actual, expected, Constant.SEARCHNEWSERROR);
		

		
	}
	

}
