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

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement editnew;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategory;
	@FindBy(xpath = "//input[@name='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=3526&page_ad=1']")
	WebElement action;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement updatecategory;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement updatesubcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement updatechoosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updatealert;

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SubCategoryPage clickNew() {
		editnew.click();
		return this;
	}

	public SubCategoryPage addCategory() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(category, 5);
		return this;

	}

	public SubCategoryPage enterSubCategory(String vegtext) {
		subcategory.sendKeys(vegtext);
		return this;
	}

	public SubCategoryPage uploadImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(updatechoosefile, Constants.MANGO);
		return this;
	}

	public SubCategoryPage clickSave() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(save));
		save.click();
		return this;
	}

	public boolean isAlertDisplyed() {
		return alert.isDisplayed();
	}

	public SubCategoryPage clickAction() {
		// action.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", action);
		return this;
	}

	public SubCategoryPage updatecategory() {
		PageUtility pageutility = new PageUtility();
		pageutility.selectByIndex(updatecategory, 3);
		return this;

	}

	public SubCategoryPage updateSubCategory(String updatetext) {
		updatesubcategory.clear();
		updatesubcategory.sendKeys(updatetext);
		return this;
	}

	public SubCategoryPage updateImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(updatechoosefile, Constants.MANGO);
		return this;
	}

	public SubCategoryPage updateSave() {
		// update.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", update);
		return this;
	}

	public boolean isUpdateAlertDisplyed() {
		return updatealert.isDisplayed();
	}
}
