package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	//take screen shot of failed test cases 
	//it give current situation of browser
	//it is done with help of TakesScreenshot-interface
	//it will call inside base class @after annotation inside driverquit()
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException { 
 		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot-interface ,it is using for capture screenshot
 		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//TakesScreenshot interface providing getScreenshotAs method
 		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); 
 		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// OutputScreenShot-directory generate of failed case
 		if (!f1.exists()) { 
 			f1.mkdirs(); //make directory if it is not existing
 		} 
 		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png"; //tell destination
 		File finalDestination = new File(destination); 
 		FileHandler.copy(screenShot, finalDestination); // FileHandler-class //copy method from FileHandler
 		//line 16 is copying to final destination
  	}
}
