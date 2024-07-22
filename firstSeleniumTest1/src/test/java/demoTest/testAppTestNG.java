package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demoPages.addToCart;
import demoPages.checkoutPage;
import demoPages.loginPage;

import utilities.*;

public class testAppTestNG {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest test;
	
	@BeforeClass
	public void extentSetUpReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
	}
	
	

	@Test(dataProvider = "excelValue", dataProviderClass = excelValueProvider.class)
	public void testLogin(String testUsername, String testPassword) {
		loginPage loginPageObj = new loginPage(driver);
		String getTitle = driver.getTitle();
		
		Assert.assertEquals(getTitle, "Swag Labs");
		test = extentReports.createTest("Test with username: " + testUsername + "and Password:" + testPassword);
		
		try {
			loginPageObj.loginToApplication(testUsername,testPassword);
			test.pass("Test passed with username: " + testUsername + "and Password:" + testPassword);
		}catch (Exception e) {
			test.fail("Test failed with username: " + testUsername + "and Password:" + testPassword);
		}
		
	}
	
	@Test
	public void addingItemsToCart() {
		addToCart addTocartObj = new addToCart(driver);
		addTocartObj.addingToCart();
	}
	
	@Test
	public void checkingOutItems() {
		checkoutPage checkOutObj = new checkoutPage(driver);
		
		checkOutObj.checkOut();
		checkOutObj.inputDetails("Sam","Paul", "1234");
		checkOutObj.finishCheckOut();
	}
	
}
