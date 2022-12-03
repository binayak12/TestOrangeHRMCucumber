Feature: Reset Employee Feature
  testing if reset feature is Employee List working

  Background:
    Given we are in login page
    When we enter valid username
    And we enter valid password
    And click on login button
    Then we get redirected to "Dashboard" page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    And we count the Total employees visible

  @smoke
  Scenario: check reset button
    Then we enter Employee Name "Binayak" in Employee List Page
    And we click on search in the Employee List Page
    And we count the Total employees visible
    Then we click on reset in the Employee List Page
    And we count the Total employees visible
    Then total number of employees visible before clicking on search and after clicking on reset should be same

