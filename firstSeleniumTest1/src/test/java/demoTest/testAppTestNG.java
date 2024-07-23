package demoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demoPages.addToCart;
import demoPages.checkoutPage;
import demoPages.loginPage;

public class testAppTestNG {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest test;
	
	@BeforeTest
	public void extentSetUpReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(spark);
		
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
	}
	
	//(dataProvider = "excelValue", dataProviderClass = excelValueProvider.class)

	@Test
	public void testLogin() {
		loginPage loginPageObj = new loginPage(driver);
		SoftAssert softAssert = new SoftAssert();
		String testUsername = "standard_user";
		String testPassword = "secret_sauce";
		String getTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		
		
		softAssert.assertEquals(getTitle, expectedTitle, "Title is not matched");
		softAssert.assertAll();
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
