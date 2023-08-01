@payBills @regression
Feature: Pay Bills Tests

  @positivePayment
  Scenario: Positive Payment Test
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    Then User should see url "http://zero.webappsecurity.com/bank/pay-bills.html"
    And User should see "The payment was successfully submitted." message after $"10" payment and "2023-07-19" date

  @negativePaymentInvalidAmount
  Scenario: Negative Payment With Invalid Amount And Valid Date
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    And User should see "Please fill out this field." error message after $"" payment and "2023-07-19" date

  @negativePaymentInvalidDate
  Scenario: Negative Payment With Valid Amount And Invalid Date
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    And User should see "Please fill out this field." date error message after $"10" payment and "" date

  @addNewPayee
  Scenario: Add New Payee Under Pay Bills
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    And User should click to Add New Payee
    And User should create new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then Message The new payee "The Law Offices of Hyde, Price & Scharks" was should successfully created. Should be displayed

  @showAllCurrencyList
  Scenario: Purchase Foreign Currency
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    And User should click to Purchase Foreign Currency
    Then Following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |

  @gettingErrorWhenNotSelectingCurrency
  Scenario: Error Message For Not Selecting Currency
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Pay Bills"
    And User should click to Purchase Foreign Currency
    When User tries to calculate cost with amount of "10" and without selecting a currency
    Then Error message "Please, ensure that you have filled all the required fields with valid values." should be displayed