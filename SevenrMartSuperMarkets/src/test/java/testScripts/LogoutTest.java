package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class LogoutTest extends Base {

	public LoginPage loginpage;
	public LogoutPage logoutpage;

	@Test(groups = { "regression" }, description = "signin page loaded")
	public void verifyUserIsAbleTologout() throws Exception {
		String usrname = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String paswrd = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usrname).enterPassword(paswrd);
		// loginpage.enterPassword(paswrd);
		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();

		// LogoutPage logout=new LogoutPage(driver);
		logoutpage.admin().logout();
		boolean loginpageloaded = logoutpage.isLoginPageLoaded();
		Assert.assertTrue(loginpageloaded);
	}
}
