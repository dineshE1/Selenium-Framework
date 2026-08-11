package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Baseclass;

public class DashboardPage extends Baseclass{
	
	//constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Locators
	By cartIcon = By.className("shopping_cart_link");
	By totalCartnum = By.className("shopping_cart_badge");
	By ScreenTitle = By.xpath("//div[text()='Swag Labs']");
	
	//methods
	
	public void addToCart(String productName) {
		String xpath = "//div[@class='inventory_item'][.//div[text()='"+productName+"']]//button";
		driver.findElement(By.xpath(xpath)).click();
		System.out.println("Added: " + productName + "to cart");
	}
	
	public void clickCartIcon() {
		waitforElementPresent(totalCartnum);
		driver.findElement(cartIcon).click();
	}
	
	public String getDashboardTitle() {
		waitforElementPresent(ScreenTitle);
		return driver.getTitle();
	}
	
	public String totalProduct() {
		return driver.findElement(totalCartnum).getText();
	}
 	
}
