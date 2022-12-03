package pages.admin.userManagement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Users {

    private WebDriver driver;
    private Actions act;
    private int waitTime = 15;;

    public Users(WebDriver driver){
        this.driver = driver;
         act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//div[@role='option']/span")
    private List<WebElement> options;
    @FindBy(xpath = "//div[@class='orangehrm-header-container']/button[@type='button']")
    private WebElement addUserButton;

    @FindBy(xpath = "(//input[@class = 'oxd-input oxd-input--active'])[2]")
    private WebElement usernameField;

    @FindBy(xpath = "(//div[@class = 'oxd-select-text-input'])[1]")
    private WebElement userRoleField;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']//input")
    private WebElement employeeNameField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement statusField;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='button']")
    private WebElement resetButton;

    @FindBy(xpath = "//div[@class='oxd-form-actions']/button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']//input")
    private List<WebElement> dataRow;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[2]/div")
    private List<WebElement> dataRowUsername;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[3]/div")
    private List<WebElement> dataRowUserRole;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[4]/div")
    private List<WebElement> dataRowEmployeeName;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[5]/div")
    private List<WebElement> dataRowStatus;

    @FindBy(className = "bi-trash")
    private List<WebElement> dataRowDelete;

    @FindBy(className = "bi-pencil-fill")
    private List<WebElement> dataRowEdit;

    @FindBy(css = ".oxd-pagination-page-item--page")
    private List<WebElement> pageNoButtonList;

    @FindBy(className = "oxd-button--label-danger")
    private WebElement deleteConfirmation;

    @FindBy(className = "oxd-button--text")
    private WebElement deleteCancel;

    public void clickAddUser() {
        addUserButton.click();
    }

    private Users selectOption(String option) {
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

    private Users selectDynamicOptions(String name) {
        boolean nameFound = false;
        for(int i = 0; i<options.size(); i++) {
            if(options.get(i).getText().toLowerCase().contains(name.toLowerCase())) {
                options.get(i).click();
                nameFound = true;
            }
        }
        if(nameFound == false) {
            act.sendKeys(Keys.ESCAPE);
        }
        return this;
    }

    public Users enterUsername(String uname) {
        usernameField.sendKeys(uname);
        return this;
    }

    public static final String userRole_Admin = "Admin";
    public static final String userRole_ESS = "ESS";
    public Users selectUserRole(String option) {
        userRoleField.click();
        selectOption(option);
        return this;
    }

    public Users enterEmployeeName(String empName) {
        employeeNameField.sendKeys(empName);
        selectDynamicOptions(empName);
        return this;
    }

    public String stauts_Enabled() {return "Enabled";}
    public String stauts_Disabled() {return "Disabled";}
    public Users selectStatus(String status) {
        statusField.click();
        selectOption(status);
        return this;
    }

    public Users clickReset() {
        resetButton.click();
        return this;
    }

    public Users clickSearch() {
        searchButton.click();
        return this;
    }

    public int noOfPages() {
        return pageNoButtonList.size();
    }

    public int getTotalUsersVisible() throws InterruptedException {
        int totalEmp = 0;
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                totalEmp++;
            }
            tempi = i+1;
            if(tempi<pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if(pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }
        return totalEmp;
    }

    public int getNoOfMatchingEmployees(String name) throws InterruptedException {
        int matchingEmp = 0;
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowEmployeeName.get(j).getText().toLowerCase().contains(name.toLowerCase())){
                    matchingEmp++;
                }
            }
            tempi = i+1;
            if(tempi<pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if(pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }
        return matchingEmp;

    }

    public boolean getUsernameAvailable(String uname) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowUsername.get(j).getText().equalsIgnoreCase(uname)) {
                    if(pageNoButtonList.size() != 0) {
                        pageNoButtonList.get(0).click();
                    }
                    return true;
                }
            }
            tempi = i+1;
            if(tempi<pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if(pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }
        return false;
    }

    public String getUsernameEmployeeName(String uname) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowUsername.get(j).getText().equalsIgnoreCase(uname)) {
                    String empName = dataRowEmployeeName.get(j).getText();
                    if(pageNoButtonList.size() != 0) {
                        pageNoButtonList.get(0).click();
                    }
                    return empName;
                }
            }
            tempi = i+1;
            if(tempi<pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if(pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }
        return null;
    }

    public void editUsername(String uname) throws InterruptedException {
        int tempi;
        for (int i = 0; i < pageNoButtonList.size() || i == 0; i++) {
            Thread.sleep(2000);
            for (int j = 0; j < dataRow.size(); j++) {
                if (dataRowUsername.get(j).getText().equalsIgnoreCase(uname)) {
                    dataRowEdit.get(j).click();
                }
            }
            tempi = i + 1;
            if (tempi < pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if (pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }

    }


    public Users deleteUsername(String uname) throws InterruptedException {
        int tempi;
        for (int i = 0; i < pageNoButtonList.size() || i == 0; i++) {
            Thread.sleep(2000);
            for (int j = 0; j < dataRow.size(); j++) {
                if (dataRowUsername.get(j).getText().equalsIgnoreCase(uname)) {
                    dataRowDelete.get(j).click();
                    return this;
                }
            }
            tempi = i + 1;
            if (tempi < pageNoButtonList.size()) {
                pageNoButtonList.get(tempi).click();
            }
        }
        if (pageNoButtonList.size() != 0) {
            pageNoButtonList.get(0).click();
        }
        return this;
    }

    public Users confirmDeleteYes(){
        try{
            deleteConfirmation.click();
            return this;
        }
        catch(Exception ex){
            return this;
        }
    }

    public Users cancelDeleteNo(){
        try{
            deleteCancel.click();
            return this;
        }
        catch(Exception ex){
            return this;
        }
    }

    public Users goToPage(int pgNumber) {
        if (pageNoButtonList.size() != 0 || pgNumber<=pageNoButtonList.size()) {
            pageNoButtonList.get(pgNumber - 1).click();
        }
        return this;
    }
}
