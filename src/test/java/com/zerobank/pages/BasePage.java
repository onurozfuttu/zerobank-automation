package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signInButton;

    public void clickToSignInButton(){
        signInButton.click();
    }

    public String getUrl(){
        return Driver.get().getCurrentUrl();
    }
}
