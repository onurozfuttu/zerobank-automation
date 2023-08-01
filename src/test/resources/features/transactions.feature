@transaction @regression
Feature: Find Transactions in Account Activity

  @transactionDateRange
  Scenario: Search Date Range
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to Find Transactions
    And User should search date between "2012-09-01" and "2012-09-06"
    Then User should see transaction dates between "2012-09-01" and "2012-09-06"
    And Results should be sorted by most recent date

  @transactionSearchDescription
  Scenario: Search Description
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to Find Transactions
    When User enters description "ONLINE"

  @transactionDepositAndWithdrawalNOTEmpty
  Scenario: Type-1
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to Find Transactions
    And User should click Find Button
    Then Results table should show at least one result under Deposit and Withdrawal

  @transactionDepositNOTEmptyAndWithdrawalEmpty
  Scenario: Type-2
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to Find Transactions
    And User should select "Deposit" under Type dropdown

  @transactionDepositIsEmptyAndWithdrawalNOTEmpty
  Scenario: Type-3
    Given User is on the main page
    When User should be able to login with valid credentials
    Then User should click to "Account Activity"
    And User should click to Find Transactions
    And User should select "Withdrawal" under Type dropdown


