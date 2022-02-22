
package com.myShop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myShop.actionDriver.Action;

public class AddressPage {
	
	Action action= new Action();
	WebDriver driver;
	
	public AddressPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	

	public ShippingPage clickOnCheckOut() throws Throwable {
		proceedToCheckOut.click();;
		return new ShippingPage(driver);
	}
	
}
