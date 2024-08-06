package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;

	public WebDriver driver;

    	
	public  PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
	   LandingPage landingPage = new LandingPage(driver);
	   return landingPage;
	}
	
	public OffersPage getOffersPage() {
		OffersPage offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	public CheckoutPage getCheckoutPage() {
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
