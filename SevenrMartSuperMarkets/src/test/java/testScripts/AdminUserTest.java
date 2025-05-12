package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;

public class AdminUserTest extends Base {
	public LogoutPage logoutpage;
	public AdminUserPage adminuser;

	@Test(groups = { "regression" }, description = "admin user details entered successfully")
	public void verifyThatUserIsAbleToSaveUserDeatils() throws Exception {

		// FakerUtility fakerutility =new FakerUtility();

		String usrname = ExcelUtilities.readStringData(1, 0, "LoginPage");
		String paswrd = ExcelUtilities.readStringData(1, 1, "LoginPage");
		String username = ExcelUtilities.readStringData(1, 0, "AdminUserPage");
		String password = ExcelUtilities.readStringData(1, 1, "AdminUserPage");
		// String username=fakerutility.creatARandomFirstName();
		// String password=fakerutility.creatARandomLastName();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(usrname).enterPassword(paswrd);

		logoutpage = loginpage.clickSignIn();
		loginpage.isHomePageLoaded();

		// AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser = logoutpage.adminUserMoreInfo();
		adminuser.adminUserNew().adminUserName(username).adminUserPassWord(password).adminUserType()
				.adminUsersaveButton();

		boolean alertmessageloaded = adminuser.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);

	}
}