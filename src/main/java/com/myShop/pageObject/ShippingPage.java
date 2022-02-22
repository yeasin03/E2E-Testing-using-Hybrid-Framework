
package com.myShop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myShop.actionDriver.Action;

public class ShippingPage{
	
	WebDriver driver;

	Action action = new Action();

	public ShippingPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	
	
	public void checkTheTerms() throws Throwable {
		action.click(driver, terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage(driver);
	}

}
