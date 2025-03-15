package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrdersPage extends BasePage {

	public OrdersPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//tr/td[2]/p")
	WebElement DisplayedProductName;

	@FindBy(xpath = "//tr/td[3]/p")
	WebElement DisplayedQuantity;

	@FindBy(xpath = "//tr/td[4]/p")
	WebElement DisplayedPrice;

	@FindBy(xpath = "//tr/td[5]/p")
	WebElement totalPriceWebElement;

	@FindBy(xpath = "//button[text()='Place Order']")
	WebElement placeOrderButtonElement;

	@FindBy(xpath="//select")
	WebElement selectElement;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement checkboxElement;
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement proceedButtonElement;
	
	@FindBy(xpath="//span[contains(text(),'Thank you, your order has been placed successfully')]")
	WebElement successmessagElement;
	public String getOrderedName() {
		String textString = gettext(DisplayedProductName);

		String product = textString.split("-")[0].trim();
		
		return product;
	}

	public int getOrderedQuantity() {
		String textString = gettext(DisplayedQuantity).trim();

		return Integer.parseInt(textString);
	}

	public int getOrderedPrice() {
		String textString = gettext(DisplayedPrice).trim();

		return Integer.parseInt(textString);
	}

	public int getTotalPrice() {

		String textString = gettext(totalPriceWebElement).trim();

		return Integer.parseInt(textString);

	}

	public void ClickPlaceorderButton() {
		click(placeOrderButtonElement);
	}
    
	
	
	
	public void Selectcountry()
	{
		selectoption(selectElement, "India");
		
	}
	
	public void clickcheckbox()
	{
		click(checkboxElement);
	}
	
	public void ClickProceedButton()
	{
		click(proceedButtonElement);
	}
	
	
	public String getsuccessmsg()
	{
		return gettext(successmessagElement).trim();
	}
	
	
}
