package com.myShop.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myShop.utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Base {
	
	
    ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public int implicitWait = readconfig.getImplicitWait();
	public int pageLoadTimeOut = readconfig.getpageLoadTimeOut();

	public WebDriver driver ;
	
		
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void launchApp() {
		
		
		
		String browserName = readconfig.getBrowser();
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver.set(new ChromeDriver());
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			
			driver = new InternetExplorerDriver();
		}
		
		
		
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		//Implicit TimeOuts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));
		//Launching the URL
		driver.get(baseURL);
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		}
		
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}

}
