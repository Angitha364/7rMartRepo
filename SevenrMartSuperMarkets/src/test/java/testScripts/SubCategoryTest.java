package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends Base{
	public LogoutPage logoutpage;
	public SubCategoryPage subcategorypage;
	@Test
	public void verifyIfUserIsAbleToAddSubCategoryDetails() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");

		String category =ExcelUtilities.readStringData(1, 0, "subcategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		logoutpage=loginpage.clickSignIn();
			loginpage.isHomePageLoaded();
			
			
			subcategorypage=logoutpage.subCategoryMoreinfo();
			subcategorypage.clickNew().addCategory().enterSubCategory(category).uploadImage().clickSave();
			boolean isgreenalertdisplayed = subcategorypage.isAlertDisplyed();
			Assert.assertTrue(isgreenalertdisplayed);
			
	}
	@Test
	public void verifyIfUserIsAbleToUpdateSubCategoryDetails() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
		
	
		String editcategory = ExcelUtilities.readStringData(1, 1, "subcategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		logoutpage=loginpage.clickSignIn();
			loginpage.isHomePageLoaded();
			
		
			subcategorypage=logoutpage.subCategoryMoreinfo();
			subcategorypage.clickAction().updatecategory().updateSubCategory(editcategory).updateImage().updateImage().updateSave();
			
			
			boolean isgreenalertdisplayed = subcategorypage.isUpdateAlertDisplyed();
			Assert.assertTrue(isgreenalertdisplayed);
	}

}


