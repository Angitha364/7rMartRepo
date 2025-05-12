package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(null);
	}

	public void mouseClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.click(element).build().perform();
	}

	public void mouseDoubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void mouseRightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void javaScriptClickSendKeys(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='Angitha';", element);
	}

	public void javaScriptClick(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

}
