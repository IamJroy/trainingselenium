package demoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToCart {

	WebDriver driver = null;
	
	By addToCartBackPack = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By addToCartJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	By viewCart = By.id("shopping_cart_container");
	
	public addToCart(WebDriver driver) {
		this.driver = driver;
		}
	
	public void addingToCart() {
		
//		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//button"));
//		
//	    int count = listOfInputElements.size();
//	    System.out.println("Count of Elements "+ count);
		
		driver.findElement(addToCartBackPack).click();
		driver.findElement(addToCartJacket).click();
		driver.findElement(viewCart).click();
	}
	
	
}
