package stepdefinitions;
import org.testng.Assert;

import Base.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DashboardPage;

public class DashboardSteps extends Baseclass{
	DashboardPage dashboardpage;
	
	private void initPages() {
		if(dashboardpage==null) {
			dashboardpage = new DashboardPage(driver);
		}	
	}
	
	@When("user adds {string} to cart")
	public void userClicksAddToCart(String productName) {
		initPages();
		dashboardpage.addToCart(productName);
	}
	
	@Then("cart should show {string} items")
	public void userCanAbleToSeeProductCount(String count) {
		initPages();
		Assert.assertEquals(
				dashboardpage.totalProduct(), count);
	        System.out.println("Count verified ✅");
	}
	
	@When("user clicks cart icon")
	public void userClicksCartIcon() {
		initPages();
		dashboardpage.clickCartIcon();
	}
}
