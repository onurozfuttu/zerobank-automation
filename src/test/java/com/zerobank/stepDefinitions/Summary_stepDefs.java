package com.zerobank.stepDefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.SummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Summary_stepDefs {
    SummaryPage summaryPage = new SummaryPage();
    DashboardPage dashboardPage = new DashboardPage();



    @And("User should be able to see following account types")
    public void user_should_be_able_to_see_following_account_types(List<String> expectedList) {
        List<String> actualList = BrowserUtils.getElementsText(summaryPage.accountTableHeaders);
        Assert.assertEquals(expectedList, actualList);
    }

    @And("User should be able to see following rows")
    public void user_should_be_able_to_see_following_rows(List<String> expectedList) {
        List<String> actualList = BrowserUtils.getElementsText(dashboardPage.creditAccounts);
        Assert.assertEquals(expectedList, actualList);
    }

    @Then("User should see {string} tab active and url is {string}")
    public void user_should_see_tab_active_and_url_is(String expectedTab, String expectedUrl) {
        WebElement actualTab = dashboardPage.activeTab;
        Assert.assertEquals(expectedTab, actualTab.getText());
        Assert.assertEquals(expectedUrl, dashboardPage.getUrl());
    }


}
