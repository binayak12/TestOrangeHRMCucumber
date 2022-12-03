@PIM
Feature: Search Employee Feature
  testing if reset feature in Employee List Page is working



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

  Scenario: Search with employee name
    And we enter Employee Id "TESTSEARCHNAME" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    Then we enter Employee Name "Binayak" in Employee List Page
    And we click on search in the Employee List Page
    Then we check the number of employee with Name "Binayak"
    And we count the Total employees visible
    Then number of employee with this name and number of employee visible after searching needs to be same

  Scenario: Search with employee id
    And we enter Employee Id "TESTSEARCHID" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "PIM" from menu
    Then we get redirected to "PIM_EmployeeList" page
    Then we check if employee with Employee Id "TESTSEARCHID" is available
    Then we enter Employee Id "TESTSEARCHID" in Employee Id Field in the Employee List Page
    And we click on search in the Employee List Page
    Then the only visible employee in the list should be one with employee id "TESTSEARCHID"
