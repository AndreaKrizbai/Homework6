package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.clickSignIn();
    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        System.out.println("Login as user");
        loginPage.login();
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        System.out.println("Verify that Account summary page is displayed");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }

    @When("user tries to log in with invalid information")
    public void user_tries_to_log_in_with_invalid_information() {
        System.out.println("Logging in with wrong credentials");
        loginPage.login("wrong", "wrong");
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        System.out.println("Verify that error message is displayed");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals(string, loginPage.errorMessage.getText());
    }
}
