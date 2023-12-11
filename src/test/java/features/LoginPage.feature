Feature: Test login functionality

  @Demo
  Scenario: Login with valid username and password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter valid username and password in login form
    And Clicks on Log in button

  @Demo
  Scenario: Login with Valid username and invalid password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter valid username and invalid password in login form
    And Clicks on Log in button
    Then Verify that the username or password is invalid

  @Demo
  Scenario: Login with invalid username and valid password data
    When Click on the My Account Button
    And Click on the Login Option
    When User enter invalid username and valid password in login form
    And Clicks on Log in button
    Then Verify that the username or password is invalid

