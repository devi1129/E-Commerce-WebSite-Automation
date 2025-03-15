package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.TestBase;
import utils.TestContextSetUp;

public class PageObjectManager {
	
	
	
	TestContextSetUp testContextSetUp;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public LandingPage getlandingpageobject()
	{
		return new LandingPage(driver);
	}
	
	public TopDealsPage gettopdealspageobject()
	{
		return new TopDealsPage(driver);
	}
    
	
	public OrdersPage getOrdersPageObject()
	{
		return new OrdersPage(driver);
	}
	
	
}
