package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Baseclass;

public class LoginPage extends Baseclass{

	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//locators
	
	By userNameField = By.id("user-name");
	By passwordField = By.id("password");
	By loginButton = By.id("login-button");
	
	// Methods
	
	public void enterUserName(String userName) {
		driver.findElement(userNameField).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginbutton() {
		driver.findElement(loginButton).click();
	}
	
	//perform Methods
	
	public void performlogin(String userName, String password){
			enterUserName(userName);
			enterPassword(password);
			clickLoginbutton();
	}
}
