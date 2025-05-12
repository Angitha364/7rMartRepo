package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageContactPage;
import utilities.ExcelUtilities;

import utilities.FakerUtility;

public class ManageContactTest extends Base {
	public LogoutPage logoutpage;
	public ManageContactPage managecontactpage;

	@Test(groups = { "regression" }, description = "Verify the user is able to update contact details")
	public void verifyIfUserAbleToUpdateContactDetails() throws Exception {
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");

		String phone = ExcelUtilities.readStringData(1, 0, "managecontact");
		String email = ExcelUtilities.readStringData(1, 1, "managecontact");
		String address = ExcelUtilities.readStringData(1, 2, "managecontact");

		/*
		 * FakerUtility fakerutility = new FakerUtility(); String manageConatctPhone=
		 * fakerutility.generatePhone(); String manageContactEmail =
		 * fakerutility.generateEmail(); String managecontactAddress =
		 * fakerutility.generateAddress();
		 */
		String manageContactDeliveryTime = ExcelUtilities.readIntegerData(1, 3, "managecontact");
		String manageContactDeliveryCharge = ExcelUtilities.readIntegerData(1, 4, "managecontact");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();

		managecontactpage = logoutpage.clickManageContactMoreInfo();
		managecontactpage.clickManageContactAction().enterManageContactPhone(phone).enterManageConatctEmail(email)
				.enterManageConatctAddress(address).enterManageContactDeliveryTime(manageContactDeliveryTime)
				.enterManageContactDeliveryCharge(manageContactDeliveryCharge).clickManageContactUpdate();

		boolean isgreenalertdisplayed = managecontactpage.isManageContactAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed, Constants.MANAGECONTACTFILE);

	}

}
