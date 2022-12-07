package pages.admin.userManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddUser {
    private WebDriver driver;
    private Actions act;
    private int waitTime = 15;

    public AddUser(WebDriver driver) throws AWTException {
        this.driver = driver;
        act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//div[@role='option']/span")
    private List<WebElement> options;

    @FindBy(xpath = "(//div[@class = 'oxd-select-text-input'])[1]")
    private WebElement userRoleField;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input")
    private WebElement employeeNameField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusField;

    @FindBy(xpath = "(//input[@class = 'oxd-input oxd-input--active'])[2]")
    private WebElement usernameField;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement passwordField;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='button']")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='submit']")
    private WebElement saveButton;

    private AddUser selectOption(String option) {
        boolean optionFound = false;
        for(int i = 0; i<options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase(option)) {
                options.get(i).click();
                optionFound = true;
            }
        }
        if(optionFound == false){
            act.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    public AddUser enterUsername(String uname) {
        usernameField.sendKeys(uname);
        return this;
    }

    public static final String userRole_Admin = "Admin";
    public static final String userRole_ESS = "ESS";
    public AddUser selectUserRole(String option) {
        userRoleField.click();
        selectOption(option);
        return this;
    }

    public AddUser enterEmployeeName(String empName) {
        employeeNameField.sendKeys(empName);
        selectOption(empName);
        return this;
    }

    public static final String stauts_Enabled = "Enabled";
    public static  final String stauts_Disabled = "Disabled";
    public AddUser selectStatus(String status) {
        statusField.click();
        selectOption(status);
        return this;
    }

    public AddUser enterPassword(String pwd) {
        passwordField.sendKeys(pwd);
        return this;
    }

    public AddUser enterConfirmndKeys(String pwd){
        confirmPasswordField.sendKeys(pwd);
        return this;
    }

    public AddUser clickCancel() {
        act.click(cancelButton).perform();
        return this;
    }

}
