package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TransactionsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[text()='Find']")
    public WebElement findButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody//tr//td[1]")
    public List<WebElement> datesList;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody//td[2]")
    public List<WebElement> descriptionResults;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[3]")
    public List<WebElement> depositResults;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//td[4]")
    public List<WebElement> withdrawalResults;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeSelect;

    public void clickFindTransactions(){
        findTransactions.click();
    }

    public void searchDate(String from, String to){
        fromDate.sendKeys(from);
        toDate.sendKeys(to);
        findButton.click();
    }
}
