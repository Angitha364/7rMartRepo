package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {

	WebDriver driver;

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement editnew;
	@FindBy(xpath = "//input[@placeholder='Enter the Category']")
	WebElement category;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discount;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseimage;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageCategoryPage clickNew() {
		editnew.click();
		return this;
	}

	public ManageCategoryPage enterCategory(String text) {
		category.sendKeys(text);
		return this;
	}

	public ManageCategoryPage clickDiscount() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToBeClickable(driver, discount);
		return this;
	}

	public ManageCategoryPage chooseImage() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseimage, Constants.IMAGEFILE);
		return this;
	}

	public ManageCategoryPage clickSave() {
		// save.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", save);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}
