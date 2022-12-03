@Admin
Feature: Search User Feature
  testing if search feature in User Management Page is working

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
  Scenario: Search with Username
    And we enter Employee Id "TESTSEARCHUSERNAME" in Add Employee Page
    When we click on "Admin" from menu
    Then we get redirected to "Admin_UserManagement_Users" page
    When we click add on Users page
    Then we get redirected to "Admin_UserManagement_AddUser" page
    Then we select User Role "Admin"
    And we enter Employee Name "Binayak Sadhukhan" in Users Page
    And we select Status "Enabled"
    And we enter Username "TESTSEARCHUSERNAME"
    And we enter Password "WrongPassword@123"
    And we enter Confirm Password "WrongPassword@123"
    And we click save button on Add User page
    Then we get redirected to "Admin_UserManagement_Users" page
    And user with "TESTSEARCHUSERNAME" would be created
    Then enter Username "TESTSEARCHUSERNAME" in Username Field in User Management Page
    Then we click on search in the User Management Page
    Then the only visible user in the list should be one with Username "TESTSEARCHUSERNAME"

  @smoke
  Scenario: Search with Username
    And we enter Employee Id "TESTSEARCHUSERNAME" in Add Employee Page
    And click on save on Add Employee Page
    When we click on "Admin" from menu
    Then we get redirected to "Admin_UserManagement_Users" page
    When we click add on Users page
    Then we get redirected to "Admin_UserManagement_AddUser" page
    Then we select User Role "Admin"
    And we enter Employee Name "Binayak Sadhukhan" in Users Page
    And we select Status "Enabled"
    And we enter Username "TESTSEARCHUSERNAME"
    And we enter Password "WrongPassword@123"
    And we enter Confirm Password "WrongPassword@123"
    And we click save button on Add User page
    Then we get redirected to "Admin_UserManagement_Users" page
    Then we check number of user with Employee Name "Binayak Sadhukhan"
    Then enter Employee Name "Binayak Sadhukhan" in Employee Name Field in User Management Page
    Then we click on search in the User Management Page
    And we count the Total users visible
    Then we check the number of users with Employee Name "Binayak Sadhukhan"
    Then number of users matching by Employee Name before searching and after searching and number of users visible after searching will be same