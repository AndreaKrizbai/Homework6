package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("the title should be Zero – Account summary")
    public void the_title_should_be_Zero_Account_summary() {
        System.out.println("Verify that title is Zero - Account Summary");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }

    @Then("the user should see following account types")
    public void the_user_should_see_following_account_types(List<String> dataTable) {
        System.out.println("Expected values: " + dataTable);
        Assert.assertEquals(dataTable, accountSummaryPage.accountTypeOption());
    }

    @Then("{string} table must have columns")
    public void table_must_have_columns(String string, List<String>  dataTable) {
        Assert.assertEquals(dataTable, accountSummaryPage.getColumnNames(string));
    }

}
