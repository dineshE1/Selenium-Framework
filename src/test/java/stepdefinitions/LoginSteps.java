package stepdefinitions;

import org.testng.Assert;

import Base.Baseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.DashboardPage;
import page.LoginPage;

public class LoginSteps extends Baseclass{

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("user is on saucedemo login page")
    public void userIsOnLoginPage() {
        // Browser already opened in Hooks
        loginPage    = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        System.out.println("On login page ✅");
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUserName(username);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginbutton();
    }

    @Then("user should see products page with title {string}")
    public void userShouldSeeProductsPage(String title) {
        Assert.assertEquals(
            dashboardPage.getDashboardTitle(), title);
        System.out.println("Dashboard verified ✅");
    }

    @Then("user should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(
            loginPage.isErrorMessageDisplayed());
        System.out.println("Error message verified ✅");
    }
}