package com.myShop.testcases;


import org.testng.Assert;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.myShop.base.Base;

import com.myShop.pageObject.HomePage;
import com.myShop.pageObject.SearchResultsPage;
import com.myShop.utility.Log;
import com.myShop.utility.Xls_Reader;


public class TC_SearchResultPageTest extends Base {
static String path = ".\\TestData\\TestData.xlsx";
	
	static Xls_Reader reader = new Xls_Reader(path);
	
	
		private HomePage home;
		private SearchResultsPage searchResultPage;
		
		
		
		@Test(groups = "Sanity",dataProvider = "searchProduct")
		public void productAvailabilityTest(String productName) throws Throwable {
			Log.startTestCase("productAvailabilityTest");
			home= new HomePage(driver);
			searchResultPage=home.searchProduct(productName);
			
			boolean result=searchResultPage.isProductAvailable();
			Assert.assertTrue(result);
			Log.endTestCase("productAvailabilityTest");
		}
		
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = reader.getRowCount("SearchProduct");
			// Total Columns
			int column = reader.getColumnCount("SearchProduct");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = reader.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}

	}


