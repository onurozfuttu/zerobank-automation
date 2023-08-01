package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class PayBills_stepDefs {
PayBillsPage payBillsPage = new PayBillsPage();
    @Then("User should see url {string}")
    public void user_should_see_url(String expectedUrl) {
        String actualUrl = payBillsPage.getUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("User should see {string} message after ${string} payment and {string} date")
    public void user_should_see_message_after_$_payment_and_date(String expectedMessage, String amount, String date) {
        payBillsPage.pay(amount,date);
        String actualMessage = payBillsPage.successfulPaymentMessageBox.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }

    @When("User should see {string} error message after ${string} payment and {string} date")
    public void user_should_see_error_message_after_$_payment_and_date(String expectedMessage, String amount, String date) {
        payBillsPage.pay(amount,date);
        String actualText = payBillsPage.amountInputBox.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualText);
    }

    @When("User should see {string} date error message after ${string} payment and {string} date")
    public void user_should_see_date_error_message_after_$_payment_and_date(String expectedMessage, String amount, String date) {
        payBillsPage.pay(amount,date);
        String actualText = payBillsPage.dateInputBox.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage,actualText);
    }

    @When("User should click to Add New Payee")
    public void user_should_click_to_add_new_payee() {
        payBillsPage.clickAddNewPayee();
    }

    @When("User should create new payee using following information")
    public void user_should_create_new_payee_using_following_information(Map<String, String> info) {
        payBillsPage.createNewPayee(info.get("Payee Name"),info.get("Payee Address"),info.get("Account"),info.get("Payee details"));
    }

    @Then("Message The new payee {string} was should successfully created. Should be displayed")
    public void message_the_new_payee_was_should_successfully_created_should_be_displayed(String string) {
        String locator = "//div[contains(text(),'"+string+"')]";
        WebElement newPayeeConfirmationInfoBox = Driver.get().findElement(By.xpath(locator));
        Assert.assertTrue(newPayeeConfirmationInfoBox.isDisplayed());
    }

    @When("User should click to Purchase Foreign Currency")
    public void user_should_click_to_purchase_foreign_currency() {
        payBillsPage.clickPurchaseForeignCurrency();
    }

    @Then("Following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyList) {
        List<WebElement> currencies = payBillsPage.currencies;
        List<String> currenciesList = BrowserUtils.getElementsText(currencies);
        Assert.assertEquals(currenciesList,currenciesList);
    }

    @When("User tries to calculate cost with amount of {string} and without selecting a currency")
    public void user_tries_to_calculate_cost_with_amount_of_and_without_selecting_a_currency(String string) {
        payBillsPage.calculateCostsWithoutCurrencySelected(string);
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        Alert alert = Driver.get().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(string,alertText);
    }
}
