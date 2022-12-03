package stepDefinations.PIM;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.Pages;

import java.util.*;

public class Search {
    public static int totalEmployeeName, totalEmployee;
    @Then("we check the number of employee with Name {string}")
    public void we_check_the_number_of_employee_with_name(String employeeName) throws InterruptedException {
        totalEmployeeName = Pages.employeeList().getNoOfMatchingEmployees(employeeName);
    }
    @Then("we enter Employee Name {string} in Employee List Page")
    public void we_enter_employee_name_in_employee_list_page(String employeeName) {
        Pages.employeeList().enterEmployeeName(employeeName);
    }
    @Then("we click on search in the Employee List Page")
    public void we_click_on_search_in_the_employee_list_page() {
        Pages.employeeList().clickSearch();
    }
    @Then("we count the Total employees visible")
    public void we_count_the_total_employees_visible() throws InterruptedException {
        totalEmployee = Pages.employeeList().getTotalEmployeeVisible();
    }
    @Then("number of employee with this name and number of employee visible after searching needs to be same")
    public void number_of_employee_with_this_name_and_number_of_employee_visible_after_searching_needs_to_be_same() {
        Assert.assertEquals(totalEmployee, totalEmployeeName);
    }

    @Then("we check if employee with Employee Id {string} is available")
    public void we_check_if_employee_with_employee_id_is_available(String employeeId) throws InterruptedException {
        Assert.assertEquals(true, Pages.employeeList().getEmployeeIdAvailable(employeeId));
    }
    @Then("we enter Employee Id {string} in Employee Id Field in the Employee List Page")
    public void we_enter_employee_id_in_employee_id_field_in_the_employee_list_page(String employeeId) {
        Pages.employeeList().enterEmployeeId(employeeId);
    }
    @Then("the only visible employee in the list should be one with employee id {string}")
    public void the_only_visible_employee_in_the_list_should_be_one_with_employee_id(String string) {

    }

}
