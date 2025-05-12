package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;// globally declared

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;// to locate webelement using findby
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement submit;
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// PageFactory-locate webelement //initElements-To initialize webelements
	}

	public LoginPage enterUserName(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
		return this;
	}

	public LogoutPage clickSignIn() {
		submit.click();
		return new LogoutPage(driver);
	}

	public boolean isHomePageLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean alertMessageLoaded() {
		return alert.isDisplayed();
	}
}
