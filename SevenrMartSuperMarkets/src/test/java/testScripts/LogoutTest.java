package testScripts;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base{
	@Test(groups={"regression"})
	public void verifyUserIsAbleTologout() throws Exception
	{
		String usrname=ExcelUtilities.readStringData(1, 0, "LoginPage");
		String paswrd=ExcelUtilities.readStringData(1, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserName(usrname);
	loginpage.enterPassword(paswrd);
	loginpage.clickSignIn();
	
	LogoutPage logout=new LogoutPage(driver);
	logout.admin();
	logout.logout();
	}
}
