package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "(//div[@class='span12'])[2]//div//div[3]//div//table//tr[1]//th")
    public List<WebElement> creditAccounts;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement activeTab;

    public WebElement dashboardTabs(String tab){
        return Driver.get().findElement(By.xpath("//ul[@class='nav nav-tabs']//li//a[text()='"+tab+"']"));
    }
}
