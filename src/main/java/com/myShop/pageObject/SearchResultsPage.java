package com.myShop.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchResultsPage {
	
WebDriver driver;
	
	public SearchResultsPage(WebDriver rdriver)
	{
		   
		
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//div[@class='product-image-container']/a[@class='product_img_link']")
	
	
	private WebElement productResult;
	
	
	
	public boolean isProductAvailable() throws Throwable {
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,450);");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView();", productResult);
		Thread.sleep(2000);
		
		return productResult.isDisplayed();
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		productResult.click();
		return new AddToCartPage(driver);
	}
}
