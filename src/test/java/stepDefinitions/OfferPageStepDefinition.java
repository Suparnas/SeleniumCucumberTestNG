package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;


public class OfferPageStepDefinition {
public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectmanager;


public OfferPageStepDefinition(TestContextSetup testContextSetup) {
	this.testContextSetup = testContextSetup;
}

	@Then("^User searched for (.+) shortname in Offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String string) {  
	    switchToofferspage();
	    OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
	    offersPage.searchitem(string);	 
	    offerPageProductName = offersPage.getProductName();
	}
	
	public void switchToofferspage() {
		//if(testContextSetup.driver.getCurrentUrl().equals(""));
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	    landingPage.selectTopDealsPage();
	    testContextSetup.genericUtils.SwitchWindowToChild();
	}
	
	@And("Validate product name in Offers Page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
		System.out.println(testContextSetup.landingPageProductName+ " is same as " + offerPageProductName);
	}
	
	
}

