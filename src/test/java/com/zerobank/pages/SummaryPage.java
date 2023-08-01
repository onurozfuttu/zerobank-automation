package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummaryPage extends BasePage {
    @FindBy(xpath = "(//div[@class='span12'])[2]//h2")
    public List<WebElement> accountTableHeaders;

    public WebElement summaryTables(String tab){
        return Driver.get().findElement(By.xpath("(//div[@class='span12'])[2]//h2[text()='"+tab+"']"));
    }
}
