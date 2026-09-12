package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base {
@Test(description ="To verify whether the user is able to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliveryBoy() throws IOException {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		ManageDeliveryBoyPage mdbp = new ManageDeliveryBoyPage(driver);
		RandomDataUtility rd = new RandomDataUtility();
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1,"LoginPage");
		lp.enterUserNameOnUserNameField(userNameValue);
		lp.enterPasswordField(passwordValue);
		lp.clickLoginButton();
		hp.manageDeliveryBoyMoreinfo();
		mdbp.addNewDeliveryBoy();
		String delBoyName = rd.genderateFullName();
			mdbp.enterDeliveryBoyName(delBoyName);
		String delBoyEmail = rd.generateRandomEmailid();
			mdbp.enterDeliveryBoyEmail(delBoyEmail);
		String delBoyPhone = rd.generateRandomPhoneNo();
			mdbp.enterDeliveryBoyPhone(delBoyPhone);
		String delBoyAddress = rd.generateRandomAddress();
			mdbp.enterDeliveryBoyAddress(delBoyAddress);
		String delBoyUsername = rd.generateRandomUsername();
			mdbp.enterDeliveryBoyUsername(delBoyUsername);
		String delBoyPassword = rd.generateRandomPassword();
			mdbp.enterDelBoyPassword(delBoyPassword);
		mdbp.saveNewDeliveryBoy(driver);
		String actual = "Alert!";
		String expected = mdbp.checkingAlertMsg();
		Assert.assertEquals(actual,expected,Constant.NEWDELIVERYBOYCREATIONERROR);

		
	}

}
