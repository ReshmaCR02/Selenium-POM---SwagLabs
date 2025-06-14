package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ScreenshotUtil;

public class CheckoutPage {
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first-name")
	WebElement firstname;
	@FindBy(id = "last-name")
	WebElement lastname;
	@FindBy(id = "postal-code")
	WebElement postalcode;
	@FindBy(id = "continue")
	WebElement continueButton;
	@FindBy(id = "finish")
	WebElement finishButton;
	@FindBy(id = "back-to-products")
	WebElement backHome;
	@FindBy(className = "complete-header")
	WebElement confirmText;
	
	public void checkoutpageInfo(String fname, String lname, String pcode) {
	    firstname.sendKeys(fname);
	    lastname.sendKeys(lname);
	    postalcode.sendKeys(pcode);
	}

	public void continueCheckout() {
	    continueButton.click();
	}
	public void finish() {
	    finishButton.click();
	    if (confirmText.isDisplayed()) {
	        ScreenshotUtil.captureScreenshot(driver, "Order_Confirmation");
	    }
	}
	public void backhomeButton() {
	    backHome.click();
	}


}
