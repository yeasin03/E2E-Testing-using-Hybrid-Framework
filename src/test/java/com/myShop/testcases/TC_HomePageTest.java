package com.myShop.testcases;


import org.testng.Assert;

import org.testng.annotations.Test;
import com.myShop.base.Base;
import com.myShop.pageObject.HomePage;
import com.myShop.utility.Log;




public class TC_HomePageTest extends Base {
	
	private HomePage homepage;
	
	
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifyLogo() throws Throwable {
		
		Log.info("verifyLogo");
		homepage = new HomePage(driver);
		boolean result=homepage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Logo is varified");
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void verifyTitle() {
		Log.info("verifyTitle");
		homepage = new HomePage(driver);
		String actTitle=homepage.getMyStoreTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle,"My Store" );
		Log.info("Title is Varified");
	}

	

}
