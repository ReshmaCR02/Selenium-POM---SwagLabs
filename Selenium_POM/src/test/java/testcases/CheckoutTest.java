package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest{
	@Test
	public void completeCheckoutTest() {
		LoginPage login = new LoginPage(driver);
		login.loginP("standard_user", "secret_sauce");
		
		ProductsPage inventory = new ProductsPage(driver);
		inventory.addItemToCart();
		inventory.goToCart();
		
		CartPage cart = new CartPage(driver);
		System.out.println("URL after going to cart: " + driver.getCurrentUrl()); 
		cart.clickCheckout();
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.checkoutpageInfo("Johnny", "Kim", "55554");
		checkout.continueCheckout();
		checkout.finish();
		MenuPage menu = new MenuPage(driver);
		menu.logout();
}
}
