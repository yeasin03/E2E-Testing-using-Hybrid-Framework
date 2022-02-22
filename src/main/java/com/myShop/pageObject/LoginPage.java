package com.myShop.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;






public class LoginPage {
	
	
WebDriver driver;
	
	public LoginPage(WebDriver rdriver)
	{
		/*this.driver=driver;
		PageFactory.initElements(driver, this);*/
		
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	
	
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="passwd")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	@CacheLookup
	WebElement submitBtnLogin;
	
	

	
	
	public  MyAccountPage login(String user, String pass) throws Throwable{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250);");
		Thread.sleep(2000);
		
		email.sendKeys(user);
		password.sendKeys(pass);
		submitBtnLogin.click();
		return new MyAccountPage(driver);
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", email);
		
		email.sendKeys(uname);
		password.sendKeys(pswd);
		submitBtnLogin.click();
		Thread.sleep(2000);
		addressPage=new AddressPage(driver);
		return addressPage;
	}
	
	public String getLoginPageTitle() {
		
		
		return driver.getTitle();
		
	}

	
}
