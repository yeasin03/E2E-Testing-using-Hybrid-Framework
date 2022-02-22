/**
 * 
 */
package com.myShop.dataProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.myShop.utility.Xls_Reader;



public class DataProviders {

    static String path = ".\\TestData\\TestData.xlsx";
	
	static Xls_Reader reader = new Xls_Reader(path);
	

//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

	@DataProvider(name = "credentials")
	public static Object[][] getCredentials() {
		// Totals rows count
		int rows = reader.getRowCount("Credentials");
		// Total Columns
		int column = reader.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = reader.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
	@DataProvider(name = "email")
	public static Object[][] getEmail() {
		// Totals rows count
		int rows = reader.getRowCount("Email");
		// Total Columns
		int column = reader.getColumnCount("Email");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = reader.getCellData("Email", j, i + 2);
			}
		}
		return data;
	}

//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
	@DataProvider(name = "getProduct")
	public static Object[][] getProduct() {
		// Totals rows count
		int rows = reader.getRowCount("ProductDetails");
		// Total Columns
		int column = reader.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = reader.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
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
	
	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = reader.getRowCount("AccountCreationData");
		// Total Columns
		int column = reader.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(reader.getCellData("AccountCreationData", j, 1),
						reader.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
		}
		return data;
	}

}
