package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage {

    @FindBy(id="signin_button")
    private WebElement signinButton;

    @FindBy(id="user_login")
    private WebElement username;

    @FindBy(id="user_password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage;


    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
    }

    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
    }

    public void clickSignIn(){
        signinButton.click();
    }

}
