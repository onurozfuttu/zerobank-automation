@login @regression
Feature: Login Tests

  @positiveLogin
  Scenario: Positive Login Test
    Given User is on the main page
    When User should be able to login with valid credentials
    Then Validate that "Account Summary" is visible

  @negativeWrongUsernameLogin
  Scenario: Negative Login Test with wrong username
    Given User is on the main page
    When User should NOT be able to login with wrong username
    Then Validate that "Login and/or password are wrong." warning message is visible

  @negativeWrongPasswordLogin
  Scenario: Negative Login Test with wrong password
    Given User is on the main page
    When User should NOT be able to login with wrong password
    Then Validate that "Login and/or password are wrong." warning message is visible