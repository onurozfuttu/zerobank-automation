package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement loginInputBox;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginSignInButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement wrongUsernameOrPasswordWarningBox;

    public void login() {
        loginInputBox.sendKeys(ConfigurationReader.get("username"));
        passwordInputBox.sendKeys(ConfigurationReader.get("password"));
        loginSignInButton.click();

        Driver.get().get(ConfigurationReader.get("url2"));
    }

    public void login(String username, String password) {
        loginInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginSignInButton.click();

        Driver.get().get(ConfigurationReader.get("url2"));
    }

    public void negativeLogin(String username, String password) {
        loginInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginSignInButton.click();
    }



}
