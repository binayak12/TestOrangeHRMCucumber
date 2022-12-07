@loginPage
Feature: Login Feature
  I want to test login feature

  Background:
    Given we are in login page

  @smoke
  Scenario: Valid username and password
    When we enter valid username
    And we enter valid password
    And click on login button
    Then we get redirected to "Dashboard" page

  @smoke
  Scenario: Invalid username and password
    When we enter username "xyz"
    And we enter password "xyz"
    And click on login button
    Then "Invalid credentials" error message shows up in login page

  @smoke
  Scenario: Valid username and invalid password
    When we enter valid username
    And we enter password "xyz"
    And click on login button
    Then "Invalid credentials" error message shows up in login page

  @smoke
  Scenario: Valid username and blank password
    When we enter valid username
    And click on login button
    Then "Required" message shows up below password field

  @smoke
  Scenario: Blank username and blank password
    And click on login button
    Then "Required" message shows up below password field
    And "Required" message shows up below username field