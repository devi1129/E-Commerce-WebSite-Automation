package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver) {
		super(driver);
	
	}

	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchboxElement ;
	
	@FindBy(xpath="//h4[@class='product-name']")
	WebElement productNameElement;
	
	@FindBy(xpath="//p[@class='product-price']")
	WebElement priceElement;	
	
	@FindBy(xpath="//a[text()='+']")
	WebElement incrementElement;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addtoCartElement;
	
	@FindBy(xpath="//a[@class='cart-icon']")
	WebElement carticonElement;
	
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement checkoutElement;
	public void search(String text)
	{
		sendKeys(searchboxElement, text);
	}
	
	
	
	public String gettextofresult()
	{
	return	gettext(productNameElement);
	}
	
	public String getpriceofproduct()
	{
		
	        // Execute the script and retrieve the content
	        String content = (String)(gettext(priceElement));
	        
	        // Remove surrounding quotes from the content value (optional step)
	        if (content != null && content.startsWith("\"") && content.endsWith("\"")) {
	            content = content.substring(1, content.length() - 1); // Remove the surrounding quotes
	        }

	        
	        System.out.println("extracted ele: " + content);
	        
	        return content;
	    }
	
	
	
	
	
	public void ClickOnIncrement()
	{
		click(incrementElement);
	}
	
	public void ClickAddtoCartButton()
	{
		click(addtoCartElement);
	}
	public void clickcarticon()
	{
		click(carticonElement);
	}
	
	public void clickcheckout()
	{
		click(checkoutElement);
	}
	
	
	}
	
	
	
	
	
	

	
	
	
	
	