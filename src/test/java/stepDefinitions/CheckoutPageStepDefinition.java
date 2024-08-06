package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public String landingPageProductName;
	public CheckoutPage checkoutPage;

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectmanager;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();

    }

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) {
		checkoutPage.checkoutItems();			
	}
	
	@Then("Verify user has the ability to enter promo code and place the order")
	public void verify_user_has_the_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());		
	}
}

