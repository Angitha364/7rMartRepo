package testScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public ScreenShotUtility scrshot;
	public Properties properties;
	public FileInputStream fileinputstream;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void browserIntilization(String browser) throws Exception {
		// driver =new EdgeDriver();
		try {
			properties = new Properties();
			fileinputstream = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fileinputstream);

		} catch (Exception e) {
			System.out.println("Invalid");
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			driver = new EdgeDriver();
		} else {
			throw new Exception("invalid browser");
		}
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();

	}

	@AfterMethod(alwaysRun = true)

	public void driverQuit(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE)

		{
			scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}

}
