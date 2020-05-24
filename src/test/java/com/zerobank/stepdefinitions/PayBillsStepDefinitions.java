package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayBillsStepDefinitions {
    PayBillsPage payBills = new PayBillsPage();

    @Then("user navigates to {string}")
    public void user_navigates_to(String string) {
        payBills.clickPayBillsTab();
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        BrowserUtils.wait(2);
        System.out.println("Verify that title is a Zero – Pay Bills");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Pay Bills", Driver.getDriver().getTitle());
    }

    @Then("user should pay saved payee with following:")
    public void user_should_pay_saved_payee_with_following(Map<String, String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putAmount(dataTable.get("Amount"));
        payBills.putDate(dataTable.get("Date"));
        payBills.putDescription(dataTable.get("Description"));
    }

    @Then("user should click pay button")
    public void user_should_click_pay_button() {
        payBills.clickPay();
    }


    @Then("success {string} should be displayed")
    public void success_should_be_displayed(String string) {
        Assert.assertTrue(payBills.getSuccessMessage(string).isDisplayed());
    }


    @Then("user puts following:")
    public void user_puts_following(Map<String,String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putDescription(dataTable.get("Description"));
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String string) {
        Assert.assertEquals(payBills.getSummary(),string);
    }

}
