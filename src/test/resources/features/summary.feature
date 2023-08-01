@summary @regression
Feature: Summary Tests

  @summaryAccount
  Scenario: Account Test
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should see "Account Summary" tab active and url is "http://zero.webappsecurity.com/bank/account-summary.html"
    And User should be able to see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @summaryCreditAccount
  Scenario: Credit Accounts Rows Test
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should see "Account Summary" tab active and url is "http://zero.webappsecurity.com/bank/account-summary.html"
    And User should be able to see following rows
      | Account     |
      | Credit Card |
      | Balance     |