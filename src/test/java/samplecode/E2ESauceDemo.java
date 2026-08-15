package samplecode;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Baseclass;
import page.CartScreen;
import page.ConfirmationScreen;
import page.DashboardPage;
import page.LoginPage;
import page.SuccessScreen;
import utilities.ConfigReader;

public class E2ESauceDemo extends Baseclass{
	
	//Page Objects
	LoginPage loginPage;
	DashboardPage dashboardPage;
	CartScreen cartScreen;
	ConfirmationScreen confirmationScreen;
	SuccessScreen successScreen;
	
	@Override
    @BeforeClass(alwaysRun = true)
    public void setup() {
        super.setup();
        System.out.println("set() finished, driver = "+ driver);
        initPages(); 
        System.out.println("Init Page finished, login page = "+ loginPage);
    }
	
	public void initPages() {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		cartScreen = new CartScreen(driver);
		confirmationScreen = new ConfirmationScreen(driver);
		successScreen = new SuccessScreen(driver);
	}
	
	//E2E Perform Methods
	
	@Test(groups = {"smoke","regression"})
	public void Login(){
		loginPage.performlogin(ConfigReader.get("username"), ConfigReader.get("password"));
	}
	
	@Test(dependsOnMethods ="Login",groups = {"smoke","regression"})
	public void verifyPageTitle() {
		assertEquals(dashboardPage.getDashboardTitle(), "Swag Labs");
		System.out.println("Page Title Verified Successfully");
	}
	
	@Test(dependsOnMethods ="verifyPageTitle",groups = {"regression"})
	public void addProduct() {
		dashboardPage.addToCart("Sauce Labs Backpack");
		dashboardPage.addToCart("Sauce Labs Onesie");
		
		assertEquals(dashboardPage.totalProduct(), "2");
        System.out.println("Cart count verified ✅");
        
        dashboardPage.clickCartIcon();
	}
	
	@Test(dependsOnMethods ="addProduct",groups = {"regression"})
	public void verifyCartScreen() {
		assertEquals(cartScreen.verifyCartTitle(), "Your Cart");
		cartScreen.verifyCartProduct("Sauce Labs Backpack");
		cartScreen.verifyCartProduct("Sauce Labs Onesie");
		cartScreen.clickCheckoutButton();
		
	}
	
	@Test(dependsOnMethods ="verifyCartScreen",groups = {"regression"})
	public void performInfoScreen() {
		cartScreen.performYourInformationScreen(ConfigReader.get("firstname"), ConfigReader.get("lastname"), ConfigReader.get("postalcode"));
	}
	
	@Test(dependsOnMethods = "performInfoScreen",groups = {"regression"})
	public void verifyConfirmationScreen() {
		confirmationScreen.verifyConfirmationScreen();
		confirmationScreen.clickFinishButton();
	}
	
	@Test(dependsOnMethods = "verifyConfirmationScreen",groups = {"regression"})
	public void verifySuccessScreen() {
		assertEquals(successScreen.verifySuccessScreenTitle(), "Thank you for your order!");
		assertEquals(successScreen.verifySuccessScreenDescription(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
		successScreen.clickGeneratePDFButton();
	}
	
	
}
