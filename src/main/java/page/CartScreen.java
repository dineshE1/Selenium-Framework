package page;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;

public class CartScreen extends Baseclass{
	//Constructor
	public CartScreen(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Locators
	By YourCartText = By.xpath("//span[text()='Your Cart']");
	By CheckoutButton = By.xpath("//button[text()='Checkout']");
	By FirstNameField = By.id("first-name");
	By LastNameField = By.id("last-name");
	By PostalCodeField = By.id("postal-code");
	By Continue = By.id("continue");
	
	//Methods
	
	public String verifyCartTitle() {
		waitforElementPresent(YourCartText);
		return driver.findElement(YourCartText).getText();
	}
	
	public void clickCheckoutButton() {
		driver.findElement(CheckoutButton).click();
	}
	
	public boolean verifyCartProduct(String productName) {
		WebElement product = driver.findElement(By.xpath("//div[text()='"+productName+"']"));
		return product.isDisplayed();
	}
	
	public void performYourInformationScreen(String firstName,String lastName,String zipCode){
		waitforElementPresent(FirstNameField);
		driver.findElement(FirstNameField).sendKeys(firstName);
		driver.findElement(LastNameField).sendKeys(lastName);
		driver.findElement(PostalCodeField).sendKeys(zipCode);
		driver.findElement(Continue).click();
	}
}
