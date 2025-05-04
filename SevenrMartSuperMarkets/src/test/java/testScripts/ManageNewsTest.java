package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{
	@Test(groups={"regression"})
	public void manageNews() throws Exception
	{
		
			String usrname=ExcelUtilities.readStringData(1, 0, "LoginPage");
			String paswrd=ExcelUtilities.readStringData(1, 1, "LoginPage");
			String message=ExcelUtilities.readStringData(0, 1, "ManageNewsPage");
			
			LoginPage loginpage=new LoginPage(driver);
			loginpage.enterUserName(usrname);
			loginpage.enterPassword(paswrd);
			loginpage.clickSignIn();
			loginpage.isHomePageLoaded();
			
			ManageNewsPage managenews=new ManageNewsPage(driver);
		managenews.manageMoreInfo();
		managenews.clickNew();
		managenews.enterText(message);
		managenews.saveButton();
		managenews.alertMessageLoaded();
		boolean alertmessageloaded=managenews.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);
	}
}
