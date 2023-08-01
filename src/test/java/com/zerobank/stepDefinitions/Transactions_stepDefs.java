package com.zerobank.stepDefinitions;

import com.zerobank.pages.TransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Transactions_stepDefs {
    TransactionsPage transactionsPage = new TransactionsPage();

    @Then("User should click to Find Transactions")
    public void user_should_click_to_find_transactions() {
        transactionsPage.clickFindTransactions();
    }

    @Then("User should search date between {string} and {string}")
    public void user_should_search_date_between_and(String from, String to) {
        transactionsPage.searchDate(from, to);
        BrowserUtils.waitFor(3);
    }

    @Then("User should see transaction dates between {string} and {string}")
    public void user_should_see_transaction_dates_between_and(String string, String string2) {
        List<WebElement> datesList = transactionsPage.datesList;
        List<String> dates = BrowserUtils.getElementsText(datesList);
        Assert.assertFalse((!dates.contains(string) | !dates.contains(string2)));
    }

    @Then("Results should be sorted by most recent date")
    public void results_should_be_sorted_by_most_recent_date() {
        List<WebElement> datesList = transactionsPage.datesList;
        List<String> dates = BrowserUtils.getElementsText(datesList);
        String firstDateStr = dates.get(0);
        String secondDateStr = dates.get(1);
        firstDateStr = firstDateStr.replace("-", "");
        secondDateStr = secondDateStr.replace("-", "");
        int firstDate = Integer.parseInt(firstDateStr);
        int secondDate = Integer.parseInt(secondDateStr);
        int lastDigitFirstNumber = Math.abs(firstDate) % 10;
        int lastDigitSecondNumber = Math.abs(secondDate) % 10;
        Assert.assertTrue(lastDigitFirstNumber > lastDigitSecondNumber);
    }

    @When("User enters description {string}")
    public void user_enters_description(String string) {
        transactionsPage.descriptionInputBox.sendKeys(string);
        transactionsPage.findButton.click();

        List<WebElement> descriptionResults = transactionsPage.descriptionResults;
        List<String> descriptions = BrowserUtils.getElementsText(descriptionResults);

        for (int i = 0; i < descriptions.size(); i++) {
            Assert.assertTrue(descriptions.get(i).contains(string));
        }
    }

    @Then("User should click Find Button")
    public void user_should_click_find_button() {
        transactionsPage.findButton.click();
    }

    @Then("Results table should show at least one result under Deposit and Withdrawal")
    public void results_table_should_show_at_least_one_result_under_deposit_and_withdrawal() {
        List<WebElement> depositResults = transactionsPage.depositResults;
        List<WebElement> withdrawalResults = transactionsPage.withdrawalResults;
        List<String> deposit = BrowserUtils.getElementsText(depositResults);
        List<String> withdrawal = BrowserUtils.getElementsText(withdrawalResults);
        Assert.assertFalse(deposit.isEmpty());
        Assert.assertFalse(withdrawal.isEmpty());
    }

    @Then("User should select {string} under Type dropdown")
    public void user_should_select_under_type_dropdown(String string) {
        Select select = new Select(transactionsPage.typeSelect);
        select.selectByVisibleText(string);
        transactionsPage.findButton.click();
        List<WebElement> depositResults = transactionsPage.depositResults;
        List<WebElement> withdrawalResults = transactionsPage.withdrawalResults;
        List<String> deposit = BrowserUtils.getElementsText(depositResults);
        List<String> withdrawal = BrowserUtils.getElementsText(withdrawalResults);
        String s = "";
        BrowserUtils.waitFor(3);

        if(string.equals("Deposit")){
            for (int i = 0; i < withdrawal.size(); i++) {
                s+=withdrawal.get(i);
            }
            Assert.assertFalse(deposit.isEmpty());
            Assert.assertTrue(s.isBlank());
        }else if(string.equals("Withdrawal")){
            for (int i = 0; i < withdrawal.size(); i++) {
                s+=deposit.get(i);
            }
            Assert.assertFalse(withdrawal.isEmpty());
            Assert.assertTrue(s.isBlank());
        }

    }
}
