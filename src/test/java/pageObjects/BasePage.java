package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

  public  WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	
		PageFactory.initElements(driver, this);

	}

	// Reusable click method with WebElement
	public void click(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);

	}

	// Reusable sendKeys method
	public void sendKeys(WebElement element, String text) {

		element.clear(); // Clear text if the field already has text
		element.sendKeys(text);
	}
	public void test()
	{

	}

//	// Wait for an element to be visible
//	private void waitForElement() {
//	
//	}

	public void selectoption(WebElement dropdown, String option) {

		Select select = new Select(dropdown);
		select.selectByVisibleText(option);

	}

	public String gettext(WebElement element) {
		return element.getText();
	}

}

