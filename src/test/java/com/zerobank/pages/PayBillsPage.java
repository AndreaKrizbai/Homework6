package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends AbstractBasePage {

    @FindBy(id = "sp_payee")
    private WebElement payee;

    @FindBy(id = "sp_account")
    private WebElement account;

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(id = "pay_saved_payees")
    private WebElement payBtn;

    @FindBy(id = "pay_bills_tab")
    private WebElement payBillsTab;


    public void selectPayee(String option) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payee));
        Select select = new Select(payee);
        select.selectByVisibleText(option);
    }

    public void selectAccount(String option) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(account));
        Select select = new Select(account);
        select.selectByVisibleText(option);
    }

    public void putAmount(String number) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(amount));
        amount.sendKeys(number);
    }

    public void putDate(String dateText) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(date));
        date.sendKeys(dateText);
    }

    public void putDescription(String text) {
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(description));
        description.sendKeys(text);
    }

    public WebElement getSuccessMessage(String text) {
        WebElement message = driver.findElement(By.xpath("//span[text()='" + text + "']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message;
    }

    public void clickPay() {
        wait.until(ExpectedConditions.elementToBeClickable(payBtn)).click();
    }


    public String getSummary() {
        return driver.findElement(By.id("sp_amount")).getAttribute("validationMessage");
    }

    public void clickPayBillsTab() {
        payBillsTab.click();
    }

}
