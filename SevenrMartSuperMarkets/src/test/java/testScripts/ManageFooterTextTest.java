package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base{
	@Test(groups={"regression"})
	
	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		String address=ExcelUtilities.readStringData(1, 0,"managefooter");
		String email=ExcelUtilities.readStringData(1, 1,"managefooter");
		String phone=ExcelUtilities.readIntegerData(1, 2, "managefooter");
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.addAction();
		managefootertextpage.addAddress(address);
		managefootertextpage.addEmail(email);
		managefootertextpage.addPhone(phone);
		managefootertextpage.updateDetails();
		boolean alertdisplayed=managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed);

	}

@Test(groups={"regression"})
public void verifyIfUpdateButtonIsDisplayed() throws Exception
{
	String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
	String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
    LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserName(username);
	loginpage.enterPassword(password);
	loginpage.clickSignIn();
	ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
	managefootertextpage.clickMoreInfo();
	managefootertextpage.addAction();
	boolean isUpdateDisplayed=managefootertextpage.isUpdateDisplayed();
	Assert.assertTrue(isUpdateDisplayed);
}
}

