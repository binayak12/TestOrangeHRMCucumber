@Admin
Feature: Reset User Feature
  testing if reset feature in User Management Page is working

  Background:
    Given we are in login page
    When we enter valid username
    And we enter valid password
    And click on login button
    Then we get redirected to "Dashboard" page
    When we click on "Admin" from menu
    Then we get redirected to "Admin_UserManagement_Users" page
    And we count the Total Users visible

  @smoke
  Scenario: check reset button
    Then we enter Employee Name "Binayak Sadhukhan" in Users Page
    And we click on search in the User Management Page
    And we count the Total Users visible
    And we click on reset in the User Management Page
    And we count the Total Users visible
    Then total number of Users visible before clicking on search and after clicking on reset should be same