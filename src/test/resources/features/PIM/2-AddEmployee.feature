#Author: your.email@your.domain.com
#Keywords Summary :

@PIM
Feature: Add Employee Feature
  testing if add feature is working
  
  Background:
  Given we are in login page
    When we enter valid username
    And we enter valid password
    And click on login button
    Then we get redirected to "Dashboard" page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    When we click on "Add Employee" from menu
    Then we get redirected to "PIM_AddEmployee" page
    When we enter Employee First Name "Binayak" in Add Employee Page
    And we enter Employee Last Name "Sadhukhan" in Add Employee Page



  @smoke
  Scenario: Add employee details and cancel
    And we enter Employee Id "TESTAEC" in Add Employee Page
    And click on cancel on Add Employee Page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    And employee with "TEST" Employee Id will not be available on the employee list of employee page


  @smoke
  Scenario: Valid employee adding
    And we enter Employee Id "TESTAES" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    And employee with "TESTAES" Employee Id will be available on the employee list of employee page