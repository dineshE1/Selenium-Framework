package stepdefinitions;

import org.testng.Assert;

import Base.Baseclass;
import io.cucumber.java.en.Then;
import page.SuccessScreen;

public class SuccessSteps extends Baseclass {
	SuccessScreen success;
	
	private void initPages() {
		success = new SuccessScreen(driver);
	}
	
	@Then("success message should be {string}")
	public void successMessage(String successmessage) {
		initPages();
		Assert.assertEquals(success.verifySuccessScreenTitle(), successmessage);
	}
	
	@Then("user clicks generate pdf button")
	public void clickGenerateButton() {
		success.clickGeneratePDFButton();
	}
}
