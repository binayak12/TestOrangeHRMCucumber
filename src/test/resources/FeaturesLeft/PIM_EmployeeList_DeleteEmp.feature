Feature: Delete Employee Freature
  testing if delete feature is working

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

  Scenario: Delete an employee
    And we enter Employee Id "TESTDELEMP" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    Then we check if employee with Employee Id "TESTDELEMP" is available
    Then we delete employee with Employee Id "TESTDELEMP"
    Then we check if employee with Employee Id "TESTDELEMP" is available
    Then employee should not be available which was available before deleting