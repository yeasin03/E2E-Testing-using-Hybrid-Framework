package com.myShop.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.myShop.base.Base;
import com.myShop.dataProvider.DataProviders;
import com.myShop.pageObject.AddToCartPage;
import com.myShop.pageObject.AddressPage;
import com.myShop.pageObject.HomePage;
import com.myShop.pageObject.LoginPage;
import com.myShop.pageObject.OrderConfirmationPage;
import com.myShop.pageObject.OrderPage;
import com.myShop.pageObject.OrderSummary;
import com.myShop.pageObject.PaymentPage;
import com.myShop.pageObject.SearchResultsPage;
import com.myShop.pageObject.ShippingPage;
import com.myShop.utility.Log;


public class TC_EndToEndTest extends Base{
	
	private HomePage home;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("endToEndTest");
		home= new HomePage(driver);
		searchResultPage=home.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(username,password,addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("endToEndTest");
	}


}
