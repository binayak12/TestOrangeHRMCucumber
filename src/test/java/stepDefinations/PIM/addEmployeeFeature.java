package stepDefinations.PIM;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.Pages;

public class addEmployeeFeature {
    @When("we click on {string} from menu")
    public void we_click_on_from_menu(String menuItem) {
        Pages.menu().clickOn(menuItem);
    }
    @When("we enter Employee First Name {string} in Add Employee Page")
    public void we_enter_employee_first_name(String employeeFirstName) {
        Pages.addEmployee().enterFirstName(employeeFirstName);
    }
    @When("we enter Employee Last Name {string} in Add Employee Page")
    public void we_enter_employee_last_name(String employeeLastName) {
        Pages.addEmployee().enterLastName(employeeLastName);
    }
    @When("we enter Employee Id {string} in Add Employee Page")
    public void we_enter_employee_id(String EmployeeId) {
        Pages.addEmployee().enterEmpId(EmployeeId);
    }
    @When("click on save on Add Employee Page")
    public void click_on_save_on_add_employee_page() {
        Pages.addEmployee().clickSave();
    }
    @When("click on cancel on Add Employee Page")
    public void click_on_cancel_on_add_employee_page() {
        Pages.addEmployee().clickCancel();
    }
    @Then("employee with {string} Employee Id will be available on the employee list of employee page")
    public void employee_with_employee_id_will_be_available_on_the_employee_list_of_employee_page(String EmployeeId) throws InterruptedException {
        Assert.assertEquals(true, Pages.employeeList().getEmployeeIdAvailable(EmployeeId));
    }
    @Then("employee with {string} Employee Id will not be available on the employee list of employee page")
    public void employee_with_employee_id_will_not_be_available_on_the_employee_list_of_employee_page(String EmployeeId) throws InterruptedException {
        Assert.assertEquals(false, Pages.employeeList().getEmployeeIdAvailable(EmployeeId));
    }
}
