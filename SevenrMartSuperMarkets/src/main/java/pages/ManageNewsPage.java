package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	

		WebDriver driver;//globally declared
		
		@FindBy(xpath="//p[text()='Manage News']")WebElement managenewsmoreinfo ;//to locate webelement using findby
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement managenewbutton;
		@FindBy(xpath="//textarea[@id='news']")WebElement managetextarea;
		@FindBy(xpath="//button[@class='btn btn-danger']")WebElement managesave;
		@FindBy(xpath="//div[@class='col-sm-12']")WebElement managealert;
		public  ManageNewsPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
		}
		public void manageMoreInfo()
		{
			managenewsmoreinfo.click();
		}
		public void clickNew()
		{
			managenewbutton.click();
		}
	public void enterText(String text)//give new variable name in method
	{
		managetextarea.sendKeys(text);
	}
	public void saveButton()
	{
		managesave.click();
	}
	public boolean alertMessageLoaded()
	{
		return managealert.isDisplayed();	
	}
}
