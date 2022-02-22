package com.myShop.testcases;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.myShop.base.Base;
import com.myShop.dataProvider.DataProviders;
import com.myShop.pageObject.AddToCartPage;
import com.myShop.pageObject.HomePage;
import com.myShop.pageObject.SearchResultsPage;
import com.myShop.utility.Log;


public class TC_AddToCartTest extends Base {
	
	private HomePage home;
	private SearchResultsPage searchResultPage;
	private AddToCartPage addToCartPage;

	
	
	@Test(groups ="Sanity",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("addToCartTest");
		home= new HomePage(driver);
		searchResultPage=home.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}
	
	

}
