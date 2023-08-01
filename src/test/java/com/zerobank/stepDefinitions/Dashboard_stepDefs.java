package com.zerobank.stepDefinitions;

import com.zerobank.pages.DashboardPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Dashboard_stepDefs {
DashboardPage dashboardPage = new DashboardPage();
    @Then("Validate that {string} is visible")
    public void validate_that_is_visible(String string) {
        WebElement actualElement = dashboardPage.dashboardTabs(string);
        Assert.assertEquals(string,actualElement.getText());
    }
}
