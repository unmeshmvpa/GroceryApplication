package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']") WebElement addNewsButton;
	@FindBy(xpath="//textarea[@id='news']") WebElement newsText;
	@FindBy(xpath="//button[@name='create']") WebElement saveNews;
	@FindBy(xpath="//h5[text()=' Alert!']") WebElement alert;
	@FindBy(xpath="//a[text()=' Search']") WebElement searchNewsButton;
	@FindBy(xpath="//input[@name='un']") WebElement searchNewsInput; 
	@FindBy(xpath="//button[@name='Search']") WebElement newsSearch;
	@FindBy(xpath="//h4[text()='Manage News']") WebElement searchResultHeading;
	public void addNews() {
	addNewsButton.click();
}
	public void addNewNews(String newNews) {
		newsText.sendKeys(newNews);
		saveNews.click();
		
	}
	public String checkingAlertMsg() {
		String alertMsg = alert.getText();
		return alertMsg;
	}
	public void initiateSearch() {
		searchNewsButton.click();
	}
	
	public void searchNews(String news ) {
		searchNewsInput.sendKeys(news);
		newsSearch.click();
	}
	public String assertaionAddNewNews() {
		String alertMsg = alert.getText();
		return alertMsg;
	}
	public String assertationSearchNews() {
		String heading = searchResultHeading.getText();
		return heading;
	}
	
}
