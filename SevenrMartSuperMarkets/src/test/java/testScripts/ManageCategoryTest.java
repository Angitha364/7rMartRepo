package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTest extends Base {
	public LogoutPage logoutpage;
	public ManageCategoryPage managecategorypage;

	@Test(groups = { "regression" }, description = "Verify user is able to add categories")
	public void verifyIfUserIsAbleToAddCategory() throws Exception {
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		// loginpage.enterPassword(password);
		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();

		// FakerUtility fakerutility = new FakerUtility();
		// String category1 = fakerutility.creatARandomFirstName();
		String categorys = ExcelUtilities.readStringData(0, 1, "managecategory");
		// ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage = logoutpage.manageCategoryMoreInfo();
		managecategorypage.clickNew().enterCategory(categorys).clickDiscount().chooseImage().clickSave();
		boolean isgreenalertdisplayed = managecategorypage.isAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);

	}

}
