package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopDealsPage extends BasePage{

	public TopDealsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[text()='Top Deals']")
	WebElement topdealslinkElement;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchElement;
	
	@FindBy(xpath="//tr/td[1]")
	WebElement topdealElement;
	
	@FindBy(xpath="//tr/td[3]")
	WebElement pricElement;
	
	public void clicktopdeals()
	{
		click(topdealslinkElement);
	}
	
	public void entertext(String text)
	{
		sendKeys(searchElement, text);
	}
	
	
	
	
	public WebElement gettopdealelement()
	{
		return topdealElement;
	}
	
	public String getprice()
	{
		return gettext(pricElement);
	}
	
}
