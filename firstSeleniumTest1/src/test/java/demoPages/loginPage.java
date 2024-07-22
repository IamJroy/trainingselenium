package demoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginPage {
	WebDriver driver = null;
			
	By userNameTextBox = By.id("user-name");
	By userPasswordTextbox = By.id("password");
	By loginButton = By.id("login-button");
	
	public loginPage(WebDriver driver) {
	this.driver = driver;
	}
	
	
	public void loginToApplication(String userName, String passWord) {
		
		driver.findElement(userNameTextBox).sendKeys(userName);
		driver.findElement(userPasswordTextbox).sendKeys(passWord);
		driver.findElement(loginButton).click();
		
		
	}
}
