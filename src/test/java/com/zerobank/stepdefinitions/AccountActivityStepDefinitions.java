package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("the user clicks to Account	activity")
    public void the_user_clicks_to_Account_activity() {
        accountSummaryPage.accountActivity();
    }

    @Then("the title should be Zero – Account	activity")
    public void the_title_should_be_Zero_Account_activity() {
        System.out.println("Verify that title is a Zero – Account Activity");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Activity", Driver.getDriver().getTitle());
    }

    @Then("the Account drop down default option should be Savings")
    public void the_Account_drop_down_default_option_should_be_Savings() {
        Assert.assertEquals("Savings",accountSummaryPage.selectDropDown());
    }

    @Then("the Account drop down  options should be displayed")
    public void the_Account_drop_down_options_should_be_displayed(List<String> dataTable) {

    }

    @Then("the transactions table should have column names")
    public void the_transactions_table_should_have_column_names(List<String> dataTable) {

    }

}
