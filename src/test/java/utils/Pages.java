package utils;

import navigate.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.PIM.AddEmployee;
import pages.PIM.EmployeeList;
import pages.admin.userManagement.AddUser;
import pages.admin.userManagement.Users;

public class Pages {

    static Menu menu;
    static LoginPage loginPage;
    static AddEmployee addEmployee;
    static EmployeeList employeeList;
    static AddUser addUser;
    static Users users;
    private static WebDriver driver;

    public static boolean setupPending = true;

    public static final String LoginPage = "LoginPage";
    public static final String Dashboard = "Dashboard";
    public static final String PIM_EmployeeList = "PIM_EmployeeList";
    public static final String PIM_AddEmployee = "PIM_AddEmployee";
    public static final String Admin_UserManagement_Users = "Admin_UserManagement_Users";
    public static final String Admin_UserManagement_AddUser = "Admin_UserManagement_AddUser";

    public static final String LoginPage_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    public static final String Dashboard_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    public static final String PIM_EmployeeList_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    public static final String PIM_AddEmployee_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
    public static final String Admin_UserManagement_Users_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
    public static final String Admin_UserManagement_AddUser_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser";

    private static void setupPages() {
        driver = BrowserFactory.getDriver();
        menu = PageFactory.initElements(driver, Menu.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        addEmployee = PageFactory.initElements(driver, AddEmployee.class);
        employeeList = PageFactory.initElements(driver, EmployeeList.class);
        addUser = PageFactory.initElements(driver, AddUser.class);
        users = PageFactory.initElements(driver, Users.class);
        setupPending = false;
    }

    public static Menu menu() {
        if(setupPending) {
            setupPages();
        }
        return menu;
    }

    public static LoginPage loginPage() {
        if(setupPending) {
            setupPages();
        }
        return loginPage;
    }

    public static AddEmployee addEmployee() {
        if(setupPending) {
            setupPages();
        }
        return addEmployee;
    }

    public static EmployeeList employeeList() {
        if(setupPending) {
            setupPages();
        }
        return employeeList;
    }

    public static AddUser addUser() {
        if(setupPending) {
            setupPages();
        }
        return addUser;
    }

    public static Users users() {
        if(setupPending) {
            setupPages();
        }
        return users;
    }

    public static boolean onPage(String page) {
        if(setupPending) {
            setupPages();
        }
        switch (page) {
            case LoginPage:
                if(driver.getCurrentUrl().equalsIgnoreCase(LoginPage_URL))
                    return true;
            case Dashboard:
                if(driver.getCurrentUrl().equalsIgnoreCase(Dashboard_URL))
                    return true;
            case PIM_EmployeeList:
                if(driver.getCurrentUrl().equalsIgnoreCase(PIM_EmployeeList_URL))
                    return true;
            case PIM_AddEmployee:
                if(driver.getCurrentUrl().equalsIgnoreCase(PIM_AddEmployee_URL))
                    return true;
            case Admin_UserManagement_Users:
                if(driver.getCurrentUrl().equalsIgnoreCase(Admin_UserManagement_Users))
                    return true;
            case Admin_UserManagement_AddUser:
                if(driver.getCurrentUrl().equalsIgnoreCase(Admin_UserManagement_AddUser_URL))
                    return true;
            default:
                return false;
        }
    }

}
