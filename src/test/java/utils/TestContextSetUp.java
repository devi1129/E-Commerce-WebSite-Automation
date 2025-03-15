package utils;

import java.security.PublicKey;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.messages.types.Product;
import pageObjects.PageObjectManager;

public class TestContextSetUp {


    public WebDriver driver;
	public String productname;
	
	public int CartAddedProductPrice;
	
	public TestBase testBase;
	
    public HashMap<String, Object> sessionmap=new HashMap<String, Object>();
	
	public String price;
	
   public	 PageObjectManager pgManager;
	public TestContextSetUp()
	{
		
		testBase=new TestBase();
		
		pgManager=new PageObjectManager(testBase.getdriver());	
	}
	
	public void initializeDriver() {
        if (testBase.getdriver() != null) {
        	
        	testBase.driver.quit();
        	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// Close the old driver if it's not null
        	testBase.driver=null;
        }
       // Set the new driver in TestBase
        pgManager = new PageObjectManager(testBase.getdriver());  // Reinitialize PageObjectManager with the new driver
    }
}
