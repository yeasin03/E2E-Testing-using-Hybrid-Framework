package com.myShop.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myShop.base.Base;
import com.myShop.dataProvider.DataProviders;
import com.myShop.pageObject.HomePage;
import com.myShop.pageObject.LoginPage;
import com.myShop.pageObject.MyAccountPage;
import com.myShop.utility.Log;



public class TC_MyAccountPage extends Base {
	
	private LoginPage LoginPage ;
	private HomePage homepage;
	private MyAccountPage myAccountPage;
	
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) throws Throwable {
		
		Log.startTestCase("Start wishListTest Test case");
		
		homepage = new HomePage(driver);
		LoginPage = homepage.clickOnSignIn();
		myAccountPage = LoginPage.login(uname, pswd);
		boolean result=myAccountPage.validateMyWishList();
		Assert.assertTrue(result);
		
		boolean result1=myAccountPage.validateOrderHistory();
		Assert.assertTrue(result1);
		Log.info("varifi orderHistoryandDetailsTest");
		Log.info("Varifi WishList");
		
		
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		Log.info("Start order History and DetailsTest Test Case");
		homepage = new HomePage(driver);
		LoginPage = homepage.clickOnSignIn();
		myAccountPage = LoginPage.login(uname, pswd);
		boolean result=myAccountPage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.info("varifi orderHistoryandDetailsTest");
	}
	

}
