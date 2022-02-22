package com.myShop.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	
WebDriver driver;
	
	public MyAccountPage(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public boolean validateMyWishList() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250);");
		return myWishList.isDisplayed();
	}
	
	public boolean validateOrderHistory() throws Throwable {
		
		return orderHistory.isDisplayed();
	}
	
	public String getTitle() throws Throwable {
		
		Thread.sleep(2000);
		String myAccountPageTitle=driver.getTitle();
		return myAccountPageTitle;
	}
	

}
