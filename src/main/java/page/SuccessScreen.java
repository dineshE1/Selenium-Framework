package page;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Baseclass;

public class SuccessScreen extends Baseclass{
	
	//Constructor
	public SuccessScreen(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Locators
	By SuccessMessageTitle = By.xpath("//h2[text()='Thank you for your order!']");
	By SuccessMessageDescription = By.xpath("//div[contains(text(),'Your order has been dispatched')]");
	By GeneratePdfButton = By.id("generate-pdf-order");
	
	
	//Methods
	
	public String verifySuccessScreenTitle() {
		waitforElementPresent(SuccessMessageTitle);
		return driver.findElement(SuccessMessageTitle).getText();
	}
	
	public String verifySuccessScreenDescription() {
		return driver.findElement(SuccessMessageDescription).getText();
	}
	
	public void clickGeneratePDFButton() {
		driver.findElement(GeneratePdfButton).click();
	}

}
