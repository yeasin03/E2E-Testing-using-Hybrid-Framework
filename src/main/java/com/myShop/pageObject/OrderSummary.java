
package com.myShop.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myShop.actionDriver.Action;




public class OrderSummary{
	
	WebDriver driver;

	Action action = new Action();

	public OrderSummary(WebDriver rdriver) {

		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage(driver); 
	}
	
}
