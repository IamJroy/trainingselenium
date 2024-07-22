package secondSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {

	static WebDriver driver = null;
	
	@BeforeTest
	public void setUptest() {
		WebDriver driver = new ChromeDriver();
	}
	
	@Test
	public static void googleSearch() {
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("Wikipedia");
		
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		
		
	}

	@AfterTest
	public void tearDownTest() {
	driver.close();
	System.out.println("Test Completed");
	}
	
}
