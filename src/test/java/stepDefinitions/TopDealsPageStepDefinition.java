package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.TopDealsPage;
import utils.TestBase;
import utils.TestContextSetUp;

public class TopDealsPageStepDefinition {
	TestContextSetUp testContextSetUp;
	public TestBase testBase;
    public boolean ProductExists=false;
    
    TopDealsPage tPage;
    LandingPage lPage;
	public TopDealsPageStepDefinition(TestContextSetUp tu) {
		this.testContextSetUp = tu;
	}

	public String topdealresult;

	@Then("^user search with same short name (.+)  in top deals page to check if product exists$")
	public void user_search_with_same_short_name_in_top_deals_page_to_check_if_result_matches_with_home_page_result(
			String query) {

		tPage = testContextSetUp.pgManager.gettopdealspageobject();
		tPage.clicktopdeals();
		testBase = testContextSetUp.testBase;
		testBase.SwitchWindowToChild();
		tPage.entertext(query);

		WebElement topdealElement = tPage.gettopdealelement();
		String topdealresult = null;
		if (topdealElement.isDisplayed())
			topdealresult = topdealElement.getText().trim();
		else
			System.out.println("topdeal element not present");

		if (topdealresult.equalsIgnoreCase("No data"))
		{
			
			System.out.println("Searched item not present in topdeals page");
		}
		else {
			ProductExists=true;
			Assert.assertEquals(testContextSetUp.productname, topdealresult);
			System.out.println("search matched");
		}

	}
	
	
	@Then("validating whether price displayed is same in both the pages")
	public void validating_whether_price_is_displayed_is_same_in_both_the_pages() {
		
		
		if(ProductExists)
		{
			lPage=testContextSetUp.pgManager.getlandingpageobject();
			
           testContextSetUp.testBase.SwitchWindowToParent();
			
			String HomepagePrice=lPage.getpriceofproduct().trim();
			
			testContextSetUp.testBase.SwitchWindowToChild();
			String TopDealsPage=tPage.getprice().trim();
			
			
			
			if(HomepagePrice.equals(TopDealsPage))
				
			{
				System.out.println("price matched in both pages");
			}
			
			else {
				System.out.println("price not matched");
				System.out.println(HomepagePrice+"-home page pricenot equal to topdeals price-"+TopDealsPage);
				Assert.assertEquals(TopDealsPage,HomepagePrice);
			}
		}
		else {
			
			System.out.println(testContextSetUp.productname+"does not exists in topdeals page");
		}
	  
	}
	


}
