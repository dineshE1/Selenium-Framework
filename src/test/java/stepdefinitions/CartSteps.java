package stepdefinitions;
import org.testng.Assert;

import Base.Baseclass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.CartScreen;

public class CartSteps extends Baseclass{
	CartScreen cartscreen;
	private void initPages() {
		if(cartscreen == null) {
			cartscreen = new CartScreen(driver);
		}
	}
	
	@Then("cart page title should be {string}")
	public void cartPageTitle(String title) {
		initPages();
		Assert.assertEquals(
				cartscreen.verifyCartTitle(), title);
	        System.out.println("Cart Title verified ✅");
	}
	
	@Then("{string} should be in cart")
	public void cartProduct(String productName) {
		initPages();
		cartscreen.verifyCartProduct(productName);
	}
	
	@When("user clicks checkout")
	public void clickCheckout() {
		initPages();
		cartscreen.clickCheckoutButton();
	}
	
	@Then("user enters first name {string}")
	public void enterFirstName(String firstname) {
		initPages();
		cartscreen.enterFirstname(firstname);
	}
	
	@Then("user enters last name {string}")
	public void enterLastName(String lastName) {
		initPages();
		cartscreen.enterLastname(lastName);
	}
	
	@Then("user enters postal code {string}")
	public void enterPostalCode(String postalcode) {
		initPages();
		cartscreen.enterPostalCode(postalcode);
	}
	
	@Then("user clicks continue")
	public void clickContinue() {
		initPages();
		cartscreen.clickContinue();
	}
	
}
