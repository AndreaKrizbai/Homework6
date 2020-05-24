package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountActivityNavigationStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @When("the user clicks on	Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        accountSummaryPage.clickToSaving();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertTrue(accountSummaryPage.title().contains("Account Activity"));
    }

    @Then("Account	drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        Assert.assertEquals("Savings", accountSummaryPage.selectDropDown());
    }

    @When("the user clicks on	Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        accountSummaryPage.clickAccount("Brokerage");
    }

    @Then("Account	drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        BrowserUtils.wait(2);
        Assert.assertEquals("Brokerage", accountSummaryPage.selectDropDown());
    }

    @When("the	user	clicks	on	Checking	link	on	the	Account	Summary	page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        accountSummaryPage.clickAccount("Checking");
    }

    @Then("Account	drop	down	should	have	Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Assert.assertEquals("Checking", accountSummaryPage.selectDropDown());
    }

    @When("the	user	clicks	on	Credit	card	link	on	the	Account	Summary	page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        accountSummaryPage.clickAccount("Credit Card");
    }

    @Then("Account	drop	down	should	have	Credit	Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Assert.assertEquals("Credit Card", accountSummaryPage.selectDropDown());
    }

    @When("the	user	clicks	on	Loan	link	on	the	Account	Summary	page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        accountSummaryPage.clickAccount("Loan");
    }

    @Then("Account	drop	down	should	have	Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Assert.assertEquals("Loan",accountSummaryPage.selectDropDown());
    }
}
