
package com.myShop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myShop.actionDriver.Action;



public class PaymentPage {
	
	WebDriver driver;

	Action action = new Action();

	public PaymentPage(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	

	
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		return new OrderSummary(driver);
	}

}
