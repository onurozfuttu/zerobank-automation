package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActivityPage extends BasePage{

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement activityDropdown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']//th")
    public List<WebElement> transactionsTable;


    public Select selectDropdown(String dropDown){
        Select select = new Select(activityDropdown);
        select.selectByVisibleText(dropDown);

        return select;
    }
}
