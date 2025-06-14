package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

	WebDriver driver;
	public MenuPage(WebDriver driver) {
	    this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	@FindBy(id = "react-burger-menu-btn")
	WebElement menuButton;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutLink;
	public void logout() {
	    menuButton.click();
	    try {
	        Thread.sleep(1000); //wait for menu to open
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    logoutLink.click();
	}

}
