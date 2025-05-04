package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {

	WebDriver driver;
	@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")WebElement managefootermoreinfo;
	@FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1')]")WebElement action;
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageFooterTextPage(WebDriver driver)
	 {
		 this.driver=driver;
			PageFactory.initElements(driver, this);
	 }
	public void clickMoreInfo()
	{
		//managefootermoreinfo.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(managefootermoreinfo, driver);
	}
	public void addAction()
	{
		//action.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(action, driver);
	}
	public void addAddress(String addresstext)
	{
		address.clear();
		address.sendKeys(addresstext);
	}
	public void addEmail(String emailtext)
	{
		email.clear();
		email.sendKeys(emailtext);
	}
	public void addPhone(String phonenumber)
	{
		phone.clear();
		phone.sendKeys(phonenumber);
	}
	public void updateDetails()
	{
		//update.click();
		PageUtility pu=new PageUtility();
		pu.javaScriptClick(update, driver);
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	public boolean isUpdateDisplayed()
	{
		return update.isDisplayed();
		
	}
}



