package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

import constants.Constants;

public class FileUploadUtility {
	
public void fileUploadUsingSendKeys(WebElement element,String  path)
{
	element.sendKeys( path);
}
public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
{
	//any of these two methods can use
	StringSelection ss=new StringSelection(path);//pdf file load
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	Robot rb=new Robot();
	rb.delay(2500);//delay to copy and paste
	rb.keyPress(KeyEvent.VK_CONTROL);//to press control+v
	rb.keyPress(KeyEvent.VK_V);
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
}
}
