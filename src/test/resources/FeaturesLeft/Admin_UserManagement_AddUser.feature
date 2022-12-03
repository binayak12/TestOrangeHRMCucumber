@Admin
Feature: Add User Feature
  testing if add user is working

  Background:
    Given we are in login page
    When we enter valid username
    And we enter valid password
    And click on login button
    Then we get redirected to "Dashboard" page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_Employee" page
    When we click on "Add Employee" from menu
    Then we get redirected to "PIM_AddEmployee" page
    When we enter Employee First Name "Binayak" in Add Employee Page
    And we enter Employee Last Name "Sadhukhan" in Add Employee Page

  @smoke
  Scenario: Add employee details and cancel
    And we enter Employee Id "TESTADDUSERCANCEL" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "Admin" from menu
    Then we get redirected to "Admin_UserManagement_Users" page
    When we click add on Users page
    Then we get redirected to "Admin_UserManagement_AddUser" page
    Then we select User Role "Admin"
    And we enter Employee Name "Binayak Sadhukhan" in Users Page
    And we select Status "Enabled"
    And we enter Username "TESTADDUSERCANCEL"
    And we enter Password "WrongPassword@123"
    And we enter Confirm Password "WrongPassword@123"
    And we click cancel button on Add User page
    Then we get redirected to "Admin_UserManagement_Users" page
    And user with "TESTADDUSERCANCEL" would not be created

  @smoke
  Scenario: Add employee details and save
    And we enter Employee Id "TESTADDUSERSAVE" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "Admin" from menu
    Then we get redirected to "Admin_UserManagement_Users" page
    When we click add on Users page
    Then we get redirected to "Admin_UserManagement_AddUser" page
    Then we select User Role "Admin"
    And we enter Employee Name "Binayak Sadhukhan" in Users Page
    And we select Status "Enabled"
    And we enter Username "TESTADDUSERSAVE"
    And we enter Password "WrongPassword@123"
    And we enter Confirm Password "WrongPassword@123"
    And we click save button on Add User Page
    Then we get redirected to "Admin_UserManagement_Users" page
    And user with "TESTADDUSERCANCEL" would be created