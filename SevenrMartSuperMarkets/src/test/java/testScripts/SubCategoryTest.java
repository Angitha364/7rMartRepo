package testScripts;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class SubCategoryTest extends Base{
	@Test
	public void verifyIfUserIsAbleToAddSubCategoryDetails() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");

		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickSignIn();
			SubCategoryPage subcategorypage = new SubCategoryPage(driver);
			subcategorypage.clickMoreInfo();
			subcategorypage.clickNew();
			subcategorypage.addCategory();
			subcategorypage.enterSubCategory(category1);
			subcategorypage.uploadImage();
			subcategorypage.clickSave();
			boolean isgreenalertdisplayed = subcategorypage.isAlertDisplyed();
			
	}
	@Test
	public void verifyIfUserIsAbleToUpdateSubCategoryDetails() throws Exception
	{
		String username = ExcelUtilities.readStringData(1, 0, "loginpage");
		String password = ExcelUtilities.readStringData(1, 1, "loginpage");
		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
		String editcategory =fakerutility.creatARandomFirstName();
		//String category1 = ExcelUtilities.readStringData(1, 0, "subcategory");
		//String editcategory = ExcelUtilities.readStringData(1, 1, "subcategory");
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickSignIn();
			SubCategoryPage subcategorypage = new SubCategoryPage(driver);
			subcategorypage.clickMoreInfo();
			subcategorypage.clickAction();
			subcategorypage.updatecategory();
			subcategorypage.updateSubCategory(editcategory);
			subcategorypage.updateImage();
			subcategorypage.updateSave();
			boolean isgreenalertdisplayed = subcategorypage.isUpdateAlertDisplyed();
			
	}

}


