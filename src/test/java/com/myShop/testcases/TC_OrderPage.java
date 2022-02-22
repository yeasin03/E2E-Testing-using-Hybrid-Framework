package com.myShop.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.myShop.base.Base;
import com.myShop.dataProvider.DataProviders;
import com.myShop.pageObject.AddToCartPage;
import com.myShop.pageObject.HomePage;
import com.myShop.pageObject.OrderPage;
import com.myShop.pageObject.SearchResultsPage;
import com.myShop.utility.Log;


public class TC_OrderPage extends Base{
	
	private HomePage home;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	
	@Test(groups = "Sanity",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		home= new HomePage(driver);
		searchResultPage=home.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}

}
