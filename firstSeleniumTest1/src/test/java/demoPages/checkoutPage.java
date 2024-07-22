package demoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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
		driver.findElement(checkOutButton).click();
	}
	
	public void inputDetails(String Fname, String Lname, String Postal) {
		
		driver.findElement(checkOutFirstNameInfo).sendKeys(Fname);
		driver.findElement(checkOutLastNameInfo).sendKeys(Lname);
		driver.findElement(checkOutPostalInfo).sendKeys(Postal);
		driver.findElement(checkOutContinueButton).click();
	}
	
	public void finishCheckOut() {
		driver.findElement(checkOutFinishButton).click();
	}
	
	
}
