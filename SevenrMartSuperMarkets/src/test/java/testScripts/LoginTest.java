package testScripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base {
	@Test(groups="regression")
	public void verifyUserAbleToLoginUsingValidCredentials() throws Exception
	{
		
		//String usrname="admin";
		//String paswrd="admin";
		String usrname=ExcelUtilities.readStringData(1, 0, "LoginPage");
		String paswrd=ExcelUtilities.readStringData(1, 1, "LoginPage");
		
		LoginPage loginpage=new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(usrname);
		loginpage.enterPassword(paswrd);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		boolean isdasboardloaded=loginpage.isHomePageLoaded();
		Assert.assertTrue(isdasboardloaded,Constants.CORRECTPASSWORD);
	}
	@Test
	public void verifyUserAbleToLoginWithCorrectUsernameWrongPassword() throws Exception
	{
		
		/*String usrname="admin";
		String paswrd="Aadmin";*/
		String usrname=ExcelUtilities.readStringData(2, 0, "LoginPage");
		String paswrd=ExcelUtilities.readStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usrname);
		loginpage.enterPassword(paswrd);
		loginpage.clickSignIn();
		loginpage.alertMessageLoaded();
		boolean alertmessageloaded=loginpage.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);
	}
	@Test
	public void verifyUserAbleToLoginWithWrongUsernameCorrectPassword() throws Exception
	{
		
		/*String usrname="Aadmin";
		String paswrd="admin";*/
		String usrname=ExcelUtilities.readStringData(3, 0, "LoginPage");
		String paswrd=ExcelUtilities.readStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usrname);
		loginpage.enterPassword(paswrd);
		loginpage.clickSignIn();
		loginpage.alertMessageLoaded();
		boolean alertmessageloaded=loginpage.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);
	}
	@Test(groups={"regression"},retryAnalyzer=retry.Retry.class,description="home page is loaded with incorrect password")
	public void verifyUserAbleToLoginWithWrongUsernameWrongPassword() throws Exception
	{
		
		/*String usrname="Aadmin";
		String paswrd="Aadmin";*/
		String usrname=ExcelUtilities.readStringData(4, 0, "LoginPage");
		String paswrd=ExcelUtilities.readStringData(4, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usrname);
		loginpage.enterPassword(paswrd);
		loginpage.clickSignIn();
		loginpage.alertMessageLoaded();
		boolean alertmessageloaded=loginpage.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded,Constants.INCORRECTPASSWORD);
	}
	@DataProvider(name="LoginProvider")
	public Object[][] getDataFromData() throws Exception
	{
		return new Object[][] {{ExcelUtilities.readStringData(4, 0, "LoginPage"),ExcelUtilities.readStringData(4, 1, "LoginPage")}};
	}
}
