package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{
    @FindBy(xpath = "//input[@id='sp_amount']")
    public WebElement amountInputBox;

    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement dateInputBox;

    @FindBy(xpath = "//input[@value='Pay']")
    public WebElement payButton;

    @FindBy(xpath = "//span[text()='The payment was successfully submitted.']")
    public WebElement successfulPaymentMessageBox;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeName;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddress;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement payeeAccount;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetails;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addButton;

    @FindBy(xpath = "(//a[text()='Purchase Foreign Currency'])[1]")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(xpath = "//select[@id='pc_currency']//option[not(text()='Select One')]")
    public List<WebElement> currencies;

    @FindBy(xpath = "//label[@class='radio inline'][3]")
    public WebElement selectedCurrency;

    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement purchaseAmountInputBox;

    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateCostsButton;

    public void pay(String amount, String date){
        amountInputBox.sendKeys(amount);
        dateInputBox.sendKeys(date);
        payButton.click();
    }

    public void clickAddNewPayee(){
        addNewPayee.click();
    }

    public void createNewPayee(String name, String Address, String Account, String details){
        payeeName.sendKeys(name);
        payeeAddress.sendKeys(Address);
        payeeAccount.sendKeys(Account);
        payeeDetails.sendKeys(details);
        addButton.click();
    }

    public void clickPurchaseForeignCurrency(){
        purchaseForeignCurrencyTab.click();
        BrowserUtils.waitFor(3);
    }

    public void calculateCostsWithoutCurrencySelected(String addAmount){
        purchaseAmountInputBox.sendKeys(addAmount);
        calculateCostsButton.click();
    }

}
