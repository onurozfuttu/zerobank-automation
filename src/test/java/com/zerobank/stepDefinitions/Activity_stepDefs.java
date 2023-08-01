package com.zerobank.stepDefinitions;

import com.zerobank.pages.ActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity_stepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    ActivityPage activityPage = new ActivityPage();


    @When("User should click to {string}")
    public void user_should_click_to(String string) {
        dashboardPage.dashboardTabs(string).click();
        BrowserUtils.waitFor(3);
    }

    @Then("User should see {string} dropdown active and url is {string}")
    public void user_should_see_dropdown_active_and_url_is(String expectedDropdown, String expectedUrl) {
        Select select = new Select(activityPage.activityDropdown);
        select.selectByVisibleText("Savings");
        WebElement actualDropdown = select.getFirstSelectedOption();
        Assert.assertEquals(expectedDropdown, actualDropdown.getText());
        Assert.assertEquals(expectedUrl, dashboardPage.getUrl());
    }

    @Then("User able to see following dropdowns")
    public void user_able_to_see_following_dropdowns(List<String> expectedList) {
        Select select = new Select(activityPage.activityDropdown);
        List<WebElement> dropdowns = select.getOptions();
        List<String> actualList = BrowserUtils.getElementsText(dropdowns);
        Assert.assertEquals(expectedList, actualList);
    }

    @Then("User should be able to see following table headers")
    public void user_should_be_able_to_see_following_table_headers(List<String> expectedList) {
        List<WebElement> actualElements = activityPage.transactionsTable;
        List<String> actualList = BrowserUtils.getElementsText(actualElements);
        Assert.assertEquals(expectedList, actualList);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expected) {
        Select select = new Select(activityPage.activityDropdown);
        select.selectByIndex(0);
        WebElement actual = select.getFirstSelectedOption();
        Assert.assertEquals(expected, actual.getText());
    }

    @And("User should click to activity {string}")
    public void user_should_click_to_activity(String expected) {
        Select select = activityPage.selectDropdown(expected);
        Assert.assertEquals(expected,select.getFirstSelectedOption().getText());

    }
}
