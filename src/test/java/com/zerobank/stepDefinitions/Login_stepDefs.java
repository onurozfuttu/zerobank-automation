package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepDefs {
    LoginPage loginPage = new LoginPage();

    @When("User should be able to login with valid credentials")
    public void the_user_should_be_able_to_login_with_valid_credentials() {
        loginPage.clickToSignInButton();
        loginPage.login();
    }

    @When("User should NOT be able to login with wrong username")
    public void user_should_not_be_able_to_login_with_wrong_username() {
        loginPage.clickToSignInButton();
        loginPage.negativeLogin("wrong username", ConfigurationReader.get("password"));
    }

    @Then("Validate that {string} warning message is visible")
    public void validate_that_warning_message_is_visible(String string) {
        Assert.assertEquals(loginPage.wrongUsernameOrPasswordWarningBox.getText(),string);
    }

    @When("User should NOT be able to login with wrong password")
    public void user_should_not_be_able_to_login_with_wrong_password() {
        loginPage.clickToSignInButton();
        loginPage.negativeLogin(ConfigurationReader.get("username"),"wrong password");
    }
}
