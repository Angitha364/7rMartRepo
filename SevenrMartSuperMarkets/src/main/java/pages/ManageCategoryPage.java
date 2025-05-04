package pages;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import constants.Constants;
import utilities.FileUploadUtility;

public class ManageCategoryPage {

		WebDriver driver;
		@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')])[3])")WebElement moreinfo;
		@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement editnew;
		@FindBy(xpath="//input[@placeholder='Enter the Category']")WebElement category;
		@FindBy(xpath="//li[@id='134-selectable']")WebElement discount;
		@FindBy(xpath="//input[@id='main_img']")WebElement chooseimage;
		@FindBy(xpath="//button[@class='btn btn-danger']")WebElement save;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
		public ManageCategoryPage(WebDriver driver)
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
		public void enterCategory(String text)
		{
			category.sendKeys(text);
		}
		public void clickDiscount()
		{
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);
					fluentWait.until(ExpectedConditions.elementToBeClickable(discount));
			discount.click();
		}
		public void chooseImage()
		{
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(chooseimage, Constants.IMAGEFILE);
		}
		public void clickSave()
		{
			//save.click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", save);
		}
		public boolean isAlertDisplayed()
		{
			return alert.isDisplayed();
		}
		
	}


