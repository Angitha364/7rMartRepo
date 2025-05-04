package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;//globally declared
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin ;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logoutbutton;
	
	public  LogoutPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public void admin()
	{
		admin.click();
	}
	public void logout()
	{
		logoutbutton.click();
	}
}
