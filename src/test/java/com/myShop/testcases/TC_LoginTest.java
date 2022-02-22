package com.myShop.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.myShop.base.Base;
import com.myShop.dataProvider.DataProviders;
import com.myShop.utility.Log;
import com.myShop.utility.ReadConfig;

import com.myShop.pageObject.HomePage;
//import com.myShop.dataProvider.DataProviders;
import com.myShop.pageObject.LoginPage;
import com.myShop.pageObject.MyAccountPage;

public class TC_LoginTest extends Base{
	private MyAccountPage myAccount;
	private HomePage homepage;
	private LoginPage login;
    ReadConfig readconfig=new ReadConfig();
	private String loginPageTitle=readconfig.getLoginPageTitle();
	
	
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials",dataProviderClass=DataProviders.class)
	public void homeLogin(String uname, String pswd) throws Throwable {
		
		//logger.info("Start Test Cases");
		Log.startTestCase("loginTest");
		
		homepage = new HomePage(driver);
		login = homepage.clickOnSignIn();
		String title = login.getLoginPageTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Login - My Store");
		myAccount = login.login(uname, pswd);
		String myAccountTitle = myAccount.getTitle();
		System.out.println(myAccountTitle);
		Assert.assertEquals(myAccountTitle, loginPageTitle);
	
		
	}
	


}
