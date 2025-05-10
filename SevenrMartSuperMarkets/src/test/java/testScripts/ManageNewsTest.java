package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	public LogoutPage logoutpage;
	public ManageNewsPage managenewspage;
	@Test(groups={"regression"})
	public void verifyUserAbleToEnterNews() throws Exception
	{
		
			String usrname=ExcelUtilities.readStringData(1, 0, "LoginPage");
			String paswrd=ExcelUtilities.readStringData(1, 1, "LoginPage");
			String message=ExcelUtilities.readStringData(0, 1, "ManageNewsPage");
			
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName(usrname).enterPassword(paswrd);
			
			//loginpage.enterPassword(paswrd);
			logoutpage=loginpage.clickSignIn();
			loginpage.isHomePageLoaded();
			
			//ManageNewsPage managenews=new ManageNewsPage(driver);
			managenewspage=logoutpage.manageMoreInfo();
			managenewspage.clickNew().enterText(message).saveButton();
		
		
		
		boolean alertmessageloaded=managenewspage.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);
	}
}
