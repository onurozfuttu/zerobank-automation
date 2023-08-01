@activity @regression
Feature: Activity Tests

  @activitySavings
  Scenario: Activity Test
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Account Activity"
    Then User should see "Savings" dropdown active and url is "http://zero.webappsecurity.com/bank/account-activity.html"
    And User able to see following dropdowns
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @activityTransactions
  Scenario: Transactions Table Test
    Given User is on the main page
    When User should be able to login with valid credentials
    And User should click to "Account Activity"
    Then User should be able to see following table headers
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |

  @activitySavingsRedirect
  Scenario: Savings Account Redirect
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And Account drop down should have "Savings" selected

  @activityBrokerageRedirect
  Scenario: Brokerage Account Redirect
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to activity "Brokerage"

  @activityCheckingRedirect
  Scenario: Checking account redirect
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to activity "Checking"

  @activityCreditCardRedirect
  Scenario: Credit Card account redirect
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to activity "Credit Card"

  @activityLoanRedirect
  Scenario: Loan account redirect
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to activity "Loan"



