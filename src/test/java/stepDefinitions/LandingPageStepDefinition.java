package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectmanager;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

	@Given("User is on Green Cart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		;
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	@When("^User searched with shortname (.+) and extracted the actual name of the product$")
	public void user_searched_with_shortname_and_extracted_the_actual_name_of_the_product(String string) throws InterruptedException {
       landingPage.searchitem(string);	 
       Thread.sleep(500);
	   testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	   System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product(String quantity) {
	    landingPage.incrementQuantity(Integer.parseInt(quantity));
	    landingPage.addToCart();
	}
	
}

