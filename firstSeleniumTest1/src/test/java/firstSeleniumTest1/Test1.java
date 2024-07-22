package firstSeleniumTest1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
	//	driver.findElement(By.id("APjFqb")).sendKeys("Wikipedia");
		WebElement googleTextbox = driver.findElement(By.name("q"));
		
		googleTextbox.sendKeys("Wikipedia");
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
	    int count = listOfInputElements.size();
	    System.out.println("Count of Elements "+ count);
	    
//		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		
//		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
	}

}
