package com.myShop.pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.myShop.base.Base;






public class HomePage extends Base {
	
	WebDriver driver;

	public HomePage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myShopLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	
	public LoginPage clickOnSignIn() throws Throwable {
		
		 Wait<WebDriver> wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(signInBtn));
	        signInBtn.click();
	        Thread.sleep(2000);
	        return new LoginPage(driver);
		
		
		
	}
	
	public boolean validateLogo() throws Throwable {
		return myShopLogo.isDisplayed();
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=driver.getTitle();
		return myStoreTitel;
	}
	
	public SearchResultsPage searchProduct(String productName) throws Throwable {
		searchProductBox.sendKeys(productName);
		
		searchButton.click();
		Thread.sleep(3000);
		
		
		return new SearchResultsPage(driver);
		
		
		
	}
	
	
}
