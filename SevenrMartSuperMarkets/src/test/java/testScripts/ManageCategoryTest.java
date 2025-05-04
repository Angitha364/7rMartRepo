package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;
//import utilities.FakerUtility;

public class ManageCategoryTest extends Base {
	@Test(groups={"regression"})
	public void verifyIfUserIsAbleToAddCategory() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
	
		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
		//String categorys=ExcelUtilities.readStringData(0, 1, "managecategory");
			ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
			managecategorypage.clickMoreInfo();
			managecategorypage.clickNew();
			managecategorypage.enterCategory(category1);
			managecategorypage.clickDiscount();
			managecategorypage.chooseImage();
			managecategorypage.clickSave();
			boolean isgreenalertdisplayed = managecategorypage.isAlertDisplayed();
			
			Assert.assertTrue(isgreenalertdisplayed);
			
			
			
	}

}
