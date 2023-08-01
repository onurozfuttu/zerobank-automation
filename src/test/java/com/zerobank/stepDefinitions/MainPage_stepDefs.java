package com.zerobank.stepDefinitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;

public class MainPage_stepDefs {
    @Given("User is on the main page")
    public void go_to_the_zero_bank_mainpage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
}
