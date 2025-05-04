package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUserTest extends Base {
	

	@Test(groups={"regression"})
	public void adminUser() throws Exception
	{
	
		FakerUtility fakerutility =new FakerUtility();
		
		String usrname=ExcelUtilities.readStringData(1, 0, "LoginPage");
	    String paswrd=ExcelUtilities.readStringData(1, 1, "LoginPage");
		/*String username=ExcelUtilities.readStringData(1, 0, "AdminUserPage");
		String password=ExcelUtilities.readStringData(1, 1, "AdminUserPage");*/
		String username=fakerutility.creatARandomFirstName();
		String password=fakerutility.creatARandomLastName();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(usrname);
		loginpage.enterPassword(paswrd);
		loginpage.clickSignIn();
		loginpage.isHomePageLoaded();
		
		AdminUserPage adminuser=new AdminUserPage(driver);
		adminuser.adminUserMoreInfo();
		adminuser.adminUserNew();
		adminuser.adminUserName(username);
		adminuser.adminUserPassWord(password);
		adminuser.adminUserType();
		adminuser.adminUsersaveButton();
		adminuser.alertMessageLoaded();
		
		boolean alertmessageloaded=adminuser.alertMessageLoaded();
		Assert.assertTrue(alertmessageloaded);
		
}
}