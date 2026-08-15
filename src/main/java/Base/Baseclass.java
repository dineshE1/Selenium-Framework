package Base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class Baseclass {
	public WebDriver driver;
	public WebDriverWait wait;
	@BeforeClass(alwaysRun = true)
	public void setup() {
			String browsername = ConfigReader.get("browser"); 
			
			if(browsername.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();  
		        Map<String, Object> prefs = new HashMap<>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        prefs.put("profile.password_manager_leak_detection", false);
		        options.setExperimentalOption("prefs", prefs);

		        
		        options.addArguments("--disable-notifications");
		        options.addArguments("--disable-popup-blocking");
		        options.addArguments("--disable-save-password-bubble");

		        
		        
		        driver = new ChromeDriver(options);
			}
			else if(browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else if(browsername.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else {
				throw new RuntimeException("Invalid browser name: " + browsername);
			}
		 	
	        driver.manage().window().maximize();
	        driver.get(ConfigReader.get("url"));
	        wait = new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout"))));
	}
	
	public WebElement waitforElementPresent(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
