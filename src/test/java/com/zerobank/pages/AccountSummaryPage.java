package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class AccountSummaryPage extends LoginPage {

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

    @FindBy(id = "aa_accountId")
    private WebElement savings;

    @FindBy(id = "account_activity_tab")
    private WebElement accountActivity;

    @FindBy(linkText = "Savings")
    private WebElement savingsLink;

    public List<String> getColumnNames(String accountType) {
        return driver.findElements(By.xpath("//h2[text()='" + accountType + "']/following-sibling::div[1]//th"))
                .stream().map(each -> each.getText()).collect(Collectors.toList());
    }

    public List<String> accountTypeOption() {
        BrowserUtils.waitForPageToLoad(20);
        return BrowserUtils.getTextFromWebElements(accountTypes);
    }

    public String selectDropDown() {
        Select select = new Select(savings);
        return select.getFirstSelectedOption().getText();
    }

    public void accountActivity() {
        accountActivity.click();
    }

    public void clickToSaving() {
        savingsLink.click();
    }

    public String title() {
        return driver.getTitle();
    }

    public void clickAccount(String account) {
        driver.findElement(By.xpath("//a[text()='" + account + "']")).click();
    }

}
