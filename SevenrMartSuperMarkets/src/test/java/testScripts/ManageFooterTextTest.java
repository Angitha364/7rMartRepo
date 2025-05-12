package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtilities;

public class ManageFooterTextTest extends Base {
	public LogoutPage logoutpage;
	public ManageFooterTextPage managefooter;

	@Test(groups = { "regression" }, description = "Verify the user is able to update footer details")

	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception {
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();

		String address = ExcelUtilities.readStringData(1, 0, "managefooter");
		String email = ExcelUtilities.readStringData(1, 1, "managefooter");
		String phone = ExcelUtilities.readIntegerData(1, 2, "managefooter");
		// ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefooter = logoutpage.clickMoreInfo();
		managefooter.addAction().addAction().addEmail(email).addPhone(phone).addAddress(address).updateDetails();
		boolean alertdisplayed = managefooter.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed, Constants.MANAGEFOOTERUPDATE);

	}

	@Test(groups = { "regression" }, description = "")
	public void verifyIfUpdateButtonIsDisplayed() throws Exception {
		String username = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String password = ExcelUtilities.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		// ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);

		managefooter.addAction();
		boolean isUpdateDisplayed = managefooter.isUpdateDisplayed();
		Assert.assertTrue(isUpdateDisplayed, Constants.MANAGEFOOTERDISPLAY);
	}
}
