package demoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class checkoutPage {
	
	WebDriver driver = null;
	
	By checkOutButton = By.id("checkout");
	By checkOutFirstNameInfo = By.id("first-name");
	By checkOutLastNameInfo = By.id("last-name");
	By checkOutPostalInfo = By.id("postal-code");
	By checkOutContinueButton = By.id("continue");
	By checkOutFinishButton = By.id("finish");
	
	public checkoutPage(WebDriver driver) {
		this.driver = driver;
		}
	
	public void checkOut() {
		
		WebElement verifyCheckOutButton = driver.findElement(checkOutButton);
		
		Assert.assertEquals(true, verifyCheckOutButton.isDisplayed());
		driver.findElement(checkOutButton).click();
	}
	
	public void inputDetails(String Fname, String Lname, String Postal) {
		WebElement verifyContinueButton  = driver.findElement(checkOutContinueButton);
		WebElement verifycheckOutFirstNameInfo = driver.findElement(checkOutFirstNameInfo);
		WebElement verifycheckOutLastNameInfo = driver.findElement(checkOutLastNameInfo);
		WebElement verifycheckOutPostalInfo = driver.findElement(checkOutPostalInfo);
		
		Assert.assertEquals(true, verifyContinueButton.isDisplayed());
		Assert.assertEquals(true, verifycheckOutFirstNameInfo.isDisplayed());
		Assert.assertEquals(true, verifycheckOutLastNameInfo.isDisplayed());
		Assert.assertEquals(true, verifycheckOutPostalInfo.isDisplayed());
		
		driver.findElement(checkOutFirstNameInfo).sendKeys(Fname);
		driver.findElement(checkOutLastNameInfo).sendKeys(Lname);
		driver.findElement(checkOutPostalInfo).sendKeys(Postal);
		driver.findElement(checkOutContinueButton).click();
	}
	
	public void finishCheckOut() {
		driver.findElement(checkOutFinishButton).click();
	}
	
	
}
