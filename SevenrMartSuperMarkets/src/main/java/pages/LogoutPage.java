package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogoutPage {
	WebDriver driver;// globally declared

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutbutton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")
	WebElement adminusermoreinfo;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')])[3])")
	WebElement moreinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
	WebElement subcategorymoreinfo;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUserPage adminUserMoreInfo() {
		// adminusermoreinfo.click();
		PageUtility pu = new PageUtility();
		pu.javaScriptClick(adminusermoreinfo, driver);
		return new AdminUserPage(driver);
	}

	public ManageNewsPage manageMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public ManageFooterTextPage clickMoreInfo() {
		// managefootermoreinfo.click();
		PageUtility pu = new PageUtility();
		pu.javaScriptClick(managefootermoreinfo, driver);
		return new ManageFooterTextPage(driver);
	}

	public ManageCategoryPage manageCategoryMoreInfo() {
		moreinfo.click();
		return new ManageCategoryPage(driver);
	}

	public ManageContactPage clickManageContactMoreInfo() {
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

	public SubCategoryPage subCategoryMoreinfo() {
		subcategorymoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public LogoutPage admin() {
		admin.click();
		return this;

	}

	public LogoutPage logout() {
		logoutbutton.click();
		return this;
	
	}

	public boolean isLoginPageLoaded() {
		return signIn.isDisplayed();

	}
}
