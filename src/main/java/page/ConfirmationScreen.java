package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;

public class ConfirmationScreen extends Baseclass{
	
	//Constructors
	public ConfirmationScreen(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Locators
	By overviewCheckoutText = By.xpath("//span[text()='Checkout: Overview']");
	By paymentInfoText = By.xpath("//div[text()='Payment Information:']");
	By shippingInfoText = By.xpath("//div[text()='Shipping Information:']");
	By priceText = By.xpath("//div[text()='Price Total']");
	By totalAmountText = By.xpath("//div[text()='Total: $']");
	By finishButton = By.xpath("//button[text()='Finish']");
	
	
	//Methods
	
	public boolean verifyConfirmationScreen() {
		waitforElementPresent(overviewCheckoutText);
		return driver.findElement(overviewCheckoutText).isDisplayed()
		&& driver.findElement(paymentInfoText).isDisplayed() 
		&& driver.findElement(priceText).isDisplayed()
		&& driver.findElement(shippingInfoText).isDisplayed()
		&& driver.findElement(totalAmountText).isDisplayed();
	}
	
	public void clickFinishButton() {
		driver.findElement(finishButton).click();
	}
}
