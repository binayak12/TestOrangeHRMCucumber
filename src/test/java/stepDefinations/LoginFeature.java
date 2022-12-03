package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Pages;

public class LoginFeature {
    @Given("we are in login page")
    public void we_are_in_login_page() {
        Pages.loginPage().getToLoginPage();
    }

    @When("we enter valid username")
    public void we_enter_valid_username() {
        Pages.loginPage().enterUsername();
    }

    @When("we enter valid password")
    public void we_enter_valid_password() {
        Pages.loginPage().enterPassword();
    }

    @When("click on login button")
    public void click_on_login_button() {
        Pages.loginPage().clickLoginBtn();
    }

    @Then("we get redirected to {string} page")
    public void we_get_redirected_to_page(String page) {
        Assert.assertEquals(true, Pages.onPage(Pages.LoginPage));
    }

    @When("we enter username {string}")
    public void we_enter_username(String username) {
        Pages.loginPage().enterUsername(username);
    }

    @When("we enter password {string}")
    public void we_enter_password(String password) {
        Pages.loginPage().enterPassword(password);
    }

    @Then("{string} error message shows up in login page")
    public void invalid_credentials_shows_up_in_login_page(String errorMessage) {
        Assert.assertEquals(errorMessage, Pages.loginPage().checkErrorMessage());
    }

    @Then("{string} message shows up below password field")
    public void required_shows_up_below_password_field(String message) {
        Assert.assertEquals(message, Pages.loginPage().checkPasswordMessage());
    }

    @Then("{string} message shows up below username field")
    public void required_shows_up_below_username_field(String message) {
        Assert.assertEquals(message, Pages.loginPage().checkUsernameMessage());
    }

}
