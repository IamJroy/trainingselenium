package secondSeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearch();
	}
	
	public static void googleSearch() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.id("APjFqb")).sendKeys("Wikipedia");
		
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		
		driver.close();
		System.out.println("Test Completed");
	}

}
