package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

@SuppressWarnings("unused")
public class AdminUserPage {

	WebDriver driver;
	@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")WebElement adminusermoreinfo ;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement adminusernewbutton ;
	@FindBy(xpath="//input[@id='username']")WebElement adminuserusername ;
	@FindBy(xpath="//input[@id='password']")WebElement adminuserpassword ;
	@FindBy(xpath="//select[@id='user_type']")WebElement adminuserusertype;
	@FindBy(xpath="//button[@name='Create']")WebElement adminuserssave ;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' or @class='close']")WebElement adminuseralert;

	public AdminUserPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	public void adminUserMoreInfo()
	{
		//adminusermoreinfo.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(adminusermoreinfo, driver);
	}
	public void adminUserNew()
	{
		//adminusernewbutton.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(adminusernewbutton, driver);
		
	}
	public void adminUserName(String usernamevalue)
	{
		adminuserusername.sendKeys(usernamevalue);
	}
	public void adminUserPassWord(String passwordvalue)
	{
		adminuserpassword.sendKeys(passwordvalue);
	}
	public void adminUserType()
	{
		//Select select = new Select(adminuserusertype);
		//select.selectByIndex(1);
		
		PageUtility pu=new PageUtility();
		pu.selectByIndex(adminuserusertype, 1);
		
		
	
	}
	public void adminUsersaveButton()
	{
		//adminuserssave.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(adminuserssave,driver);
		
	}
	public boolean alertMessageLoaded()
	{
		return adminuseralert.isDisplayed();	
	}
	
}
