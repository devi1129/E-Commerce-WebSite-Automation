package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.devtools.v85.network.model.BlockedCookieWithReason;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.CucumberScenarioExamples;
import utils.PropertiesFile;
import utils.TestContextSetUp;

public class HomePageStepDefinition {
	private static final Logger LOG = LogManager.getLogger(HomePageStepDefinition.class);
	TestContextSetUp testContextSetUp;

	LandingPage lPage;

	public HomePageStepDefinition(TestContextSetUp tu) {
		this.testContextSetUp = tu;
	}

	@Given("user is on Green kart landing page")
	public void user_is_on_green_kart_landing_page() {

	}

	@When("^User search with short name (.+) in home page search and extracted result$")
	public void user_search_with_short_name_in_home_page_search_and_extracted_result(String query) {

		lPage = testContextSetUp.pgManager.getlandingpageobject();

		lPage.search(query);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String splitString = lPage.gettextofresult();
		testContextSetUp.productname = (splitString.split("-")[0]).trim();
		LOG.info("Successfully Searched and Extracted result");
		System.out.println(testContextSetUp.productname);

	}

	@When("^user searches for (.+) and adds it to the cart with quantity (.+)$")
	public void user_searches_for_and_adds_it_to_the_cart_with_quantity(String product, int quantity) {
		lPage = testContextSetUp.pgManager.getlandingpageobject();

		lPage.search(product);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String splitString = lPage.gettextofresult();
		testContextSetUp.productname = (splitString.split("-")[0]).trim();

		System.out.println(testContextSetUp.productname + "product from place order");

		testContextSetUp.CartAddedProductPrice = Integer.parseInt(lPage.getpriceofproduct().trim());

		for (int i = 1; i < quantity; i++)
			lPage.ClickOnIncrement();
		lPage.ClickAddtoCartButton();
		LOG.info("Sucess fully Added item to Cart");

	}

	@When("User searched with short name from excel_file in home page search and extracted result")
	public void user_search_with_short_name_in_home_page_search_and_extracted_result() {
		// Use the dynamically loaded data here
		List<Map<String, String>> dataList = CucumberScenarioExamples.getExamples();

		for (int i = 0; i < dataList.size(); i++) {
			Map<String, String> row = dataList.get(i);
			String productName = row.get("Product Name");
			user_search_with_short_name_in_home_page_search_and_extracted_result(productName);

			TopDealsPageStepDefinition tPageStepDefinition = new TopDealsPageStepDefinition(testContextSetUp);
			tPageStepDefinition
					.user_search_with_same_short_name_in_top_deals_page_to_check_if_result_matches_with_home_page_result(
							productName);
			tPageStepDefinition.validating_whether_price_is_displayed_is_same_in_both_the_pages();

			testContextSetUp.initializeDriver();

		}
		LOG.info("Successfully Searched excel data item and Extracted result");
	}

	@When("user searches for product from excel_file and adds it to the cart with desired quantity")
	public void user_searches_for_product_from_excel_file_and_adds_it_to_the_cart_with_desired_quantity() {
		List<Map<String, String>> dataList = CucumberScenarioExamples.getExamples();

		for (int i = 0; i < dataList.size(); i++) {
			Map<String, String> row = dataList.get(i);
			String productName = row.get("Product");

			// Correct way to split on the dot (.)
			String quantity = row.get("Quantity");

			int quantity2 = Integer.parseInt(quantity);

			System.out.println(quantity + "from excel");

			user_searches_for_and_adds_it_to_the_cart_with_quantity(productName, quantity2);
			System.out.println("passed add cart");

			PlaceOrderPageStepDefinition pStepDefinition = new PlaceOrderPageStepDefinition(testContextSetUp);

			pStepDefinition.the_cart_should_display_with_quantity_price_total_cost(productName, quantity);
			System.out.println("passed total cost");
			pStepDefinition.user_places_the_order();
			testContextSetUp.initializeDriver();
			

		}
		LOG.info("Successfully Added excel data item to cart");
	}
}
