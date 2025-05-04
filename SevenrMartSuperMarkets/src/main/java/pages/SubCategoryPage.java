package pages;


	import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import constants.Constants;
	import utilities.FileUploadUtility;
	import utilities.PageUtility;

	public class SubCategoryPage {
		WebDriver driver;
		@FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")WebElement moreinfo;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement editnew;
		@FindBy(xpath="//select[@id='cat_id']")WebElement category;
		@FindBy(xpath="//input[@id='subcategory']")WebElement subcategory;
		@FindBy(xpath="//input[@name='main_img']")WebElement choosefile;
		@FindBy(xpath="//button[@class='btn btn-danger']")WebElement save;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3526&page_ad=1']")WebElement action;
		@FindBy(xpath="//select[@id='cat_id']")WebElement updatecategory;
		@FindBy(xpath="//input[@id='subcategory']")WebElement updatesubcategory;
		@FindBy(xpath="//input[@id='main_img']")WebElement updatechoosefile;
		@FindBy(xpath="//button[@class='btn btn-danger']")WebElement update;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement updatealert;
		public SubCategoryPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		public void clickMoreInfo()
		{
			moreinfo.click();
		}
		public void clickNew()
		{
			editnew.click();
		}
		public void addCategory()
		{
			PageUtility pageutility = new PageUtility();
			pageutility.selectByIndex(category, 5);
			
			
		}
		public void enterSubCategory(String vegtext)
		{
			subcategory.sendKeys(vegtext);
		}
		public void uploadImage()
		{
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(updatechoosefile, Constants.MANGO);
		}
		public void clickSave()
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(save));
			save.click();
		}
		public boolean isAlertDisplyed()
		{
			return alert.isDisplayed();
		}
		public void clickAction()
		{
			//action.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", action);
		}
		public void updatecategory()
		{
			PageUtility pageutility = new PageUtility();
			pageutility.selectByIndex(updatecategory, 5);
			
		}
		public void updateSubCategory(String updatetext)
		{
			updatesubcategory.clear();
			updatesubcategory.sendKeys(updatetext);
		}
		public void updateImage()
		{
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(updatechoosefile, Constants.MANGO);
		}
		public void updateSave()
		{
			//update.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();",update );
		}
		public boolean isUpdateAlertDisplyed()
		{
			return updatealert.isDisplayed();
		}
	}

