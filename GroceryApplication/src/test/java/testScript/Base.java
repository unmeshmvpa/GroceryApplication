package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	Properties prop;
	FileInputStream fis;
	@BeforeMethod(alwaysRun = true)
	@Parameters("browsers")
	public void browserInitialization(String browsers) throws IOException {
		prop = new Properties();
		fis = new FileInputStream(Constant.CONFIGFILE);
		prop.load(fis);
		if (browsers.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult itestresult) throws IOException
	{
		if(itestresult.getStatus()==ITestResult.FAILURE) 
		{
			ScreenshotUtility screenshotutility=new ScreenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
	}
//	public void browserQuitAndClose() {
//		driver.close();
//		driver.quit();
//	}

// public static void main(String args[]) {
//	 Base b = new Base();
//	 b.browserInitialization();
//	 b.closeBrowser();
 
// }
}
//ITestResult is an interface used to manage the life cycle