package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demoPages.addToCart;
import demoPages.checkoutPage;
import demoPages.loginPage;

import utilities.*;

public class testApp {
	static WebDriver driver = new ChromeDriver();;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		testLogin();
		addingItemsToCart();
		checkingOutItems();
		
	}
	
	public static void testLogin() {
		loginPage loginPageObj = new loginPage(driver);
		String testUsername = excelUtilities.getCellValue(1, 0);
		String testPassword = excelUtilities.getCellValue(1, 1);
		
		driver.get("https://www.saucedemo.com/");
		loginPageObj.loginToApplication(testUsername,testPassword);
		
		
	}
	
	public static void addingItemsToCart() {
		addToCart addTocartObj = new addToCart(driver);
		
		addTocartObj.addingToCart();
	}
	
	public static void checkingOutItems() {
		checkoutPage checkOutObj = new checkoutPage(driver);
		
		checkOutObj.checkOut();
		checkOutObj.inputDetails("Sam","Paul", "1234");
		checkOutObj.finishCheckOut();
	}

}
