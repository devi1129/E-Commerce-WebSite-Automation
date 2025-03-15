package stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OrdersPage;
import pageObjects.TopDealsPage;
import utils.TestContextSetUp;

public class PlaceOrderPageStepDefinition {


	TestContextSetUp testContextSetUp;
	OrdersPage ordersPage;
	LandingPage lPage;

	public PlaceOrderPageStepDefinition(TestContextSetUp tu) {
		this.testContextSetUp = tu;
	}

	@Then("^the cart should display (.+) with quantity (.+)$")
	public void the_cart_should_display_with_quantity_price_total_cost(String product, String quantity2) {
	int	quantity=Integer.parseInt(quantity2);

		lPage = testContextSetUp.pgManager.getlandingpageobject();

		lPage.clickcarticon();
		lPage.clickcheckout();

		ordersPage = testContextSetUp.pgManager.getOrdersPageObject();

		String displayedname = ordersPage.getOrderedName();

		int displayedquantity = ordersPage.getOrderedQuantity();

		int displayedprice = ordersPage.getOrderedPrice();

		int displayedtotalprice = ordersPage.getTotalPrice();

		int expectedtotal = quantity * testContextSetUp.CartAddedProductPrice;

		if (displayedname.equalsIgnoreCase(product.trim())) {

			if (displayedprice == testContextSetUp.CartAddedProductPrice) {
				if (displayedquantity == quantity) {
					System.out.println("Quantity matched");

					if (expectedtotal == displayedtotalprice) {
						System.out.println("Total Price Matched");

					} else {

						System.out.println("Total price displayed incorrect" + "Expected-" + expectedtotal
								+ " displayed-" + displayedtotalprice);
						Assert.assertEquals(displayedtotalprice,expectedtotal);
					}
				}

				else {
					System.out.println("Quantity not Matched");
					Assert.assertEquals(displayedquantity,quantity);
				}
			} else {
				System.out.println("Price Displayed wrongly");
				Assert.assertEquals(displayedprice,testContextSetUp.CartAddedProductPrice);
			}

		}

		else {
			System.out.println("Product Name displayed incorrect in Orders page" + displayedname + "actual name");
			Assert.assertEquals( displayedname,product);
		}

	}

	@Then("user places the order")
	public void user_places_the_order() {

		ordersPage.ClickPlaceorderButton();
		ordersPage.Selectcountry();
		ordersPage.clickcheckbox();
		ordersPage.ClickProceedButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ordersPage.getsuccessmsg());
	}

}
