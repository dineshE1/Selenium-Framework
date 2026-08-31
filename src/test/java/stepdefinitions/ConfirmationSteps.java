package stepdefinitions;

import Base.Baseclass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.ConfirmationScreen;

public class ConfirmationSteps extends Baseclass {
	ConfirmationScreen confirmationscreen;
	
	private void initPages() {
		confirmationscreen = new ConfirmationScreen(driver);
	}
	
	@Then("checkout overview should be displayed")
	public void confirmationScreen() {
		initPages();
		confirmationscreen.verifyConfirmationScreen();
	}
	
	@When("user clicks finish")
	public void clickFinishButton() {
		initPages();
		confirmationscreen.clickFinishButton();
	}
	
}
