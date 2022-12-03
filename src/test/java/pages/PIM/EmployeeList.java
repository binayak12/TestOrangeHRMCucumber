package pages.PIM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmployeeList {

    private WebDriver driver;
    private int waitTime = 15;;
    private Actions act;

    public EmployeeList(WebDriver driver){
        this.driver = driver;
        act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    private WebElement empNameField;

    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
    private WebElement supervisorNameField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement empIdField;

    @FindBy(xpath = "//div[@role='option']/span")
    private List<WebElement> options;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[1]")
    private WebElement empStatusField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[2]")
    private WebElement includeField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
    private WebElement jobTitleField;

    @FindBy(xpath = "(//div[@class='oxd-select-text-input'])[4]")
    private WebElement subUnitField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@type = 'reset']")
    private WebElement resetButton;

    @FindBy(css = ".oxd-pagination-page-item--page")
    private List<WebElement> pageNoButtonList;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']//input")
    private List<WebElement> dataRow;

     @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[3]/div")
     private List<WebElement> dataRowFirstName;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[4]/div")
    private List<WebElement> dataRowLastName;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[@role='row']/div[2]/div")
    private List<WebElement> dataRowId;

    @FindBy(className = "bi-trash")
    private List<WebElement> dataRowDelete;

    @FindBy(className = "bi-pencil-fill")
    private List<WebElement> dataRowEdit;

    @FindBy(className = "oxd-button--label-danger")
    private WebElement deleteConfirmation;

    @FindBy(className = "oxd-button--text")
    private WebElement deleteCancel;

    private EmployeeList selectOption(String option) {
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

    private EmployeeList selectDynamicOptions(String name) {
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


    public static final String employeeStatus_Freelance = "Freelance";
    public static final String employeeStatus_FullTimeContract = "Full-Time Contract";
    public static final String employeeStatus_FullTimePermanent = "Full-Time Permanent";
    public static final String employeeStatus_FullTimeProbation = "Full-Time Probation";
    public static final String employeeStatus_PartTimeContract = "Part-Time Contract";
    public static final String employeeStatus_PartTimeInternship = "Part-Time Internship";
    public EmployeeList selectEmployeeStatus (String option) {
        empStatusField.click();
        selectOption(option);
        return this;
    }

    public static final String include_CurrentEmployeesOnly = "Current Employees Only";
    public static final String include_CurrentAndPastEmployees = "Current and Past Employees";
    public static final String include_PastEmployeesOnly = "Past Employees Only";
    public EmployeeList selectInclude(String option) {
        includeField.click();
        selectOption(option);
        return this;
    }

    public static final String jobTitle_AccountAssistant = "Account Assistant";
    public static final String jobTitle_ChiefExecutiveOfficer = "Chief Executive Officer";
    public static final String jobTitle_ChiefFinancialOfficer = "Chief Financial Officer";
    public static final String jobTitle_ChiefTechnicalOfficer = "Chief Technical Officer";
    public static final String jobTitle_ContentSpecialist = "Content Specialist";
    public static final String jobTitle_CustomerSuccessManager = "Customer Success Manager";
    public static final String jobTitle_FinanceManager = "Finance Manager";
    public static final String jobTitle_FinancialAnalyst = "Financial Analyst";
    public static final String jobTitle_HeadOfSupport = "Head of Support";
    public static final String jobTitle_HRAssociate = "HR Associate";
    public static final String jobTitle_HRManager = "HR Manager";
    public static final String jobTitle_ITManager = "IT Manager";
    public static final String jobTitle_NetworkAdministrator = "Network Administrator";
    public static final String jobTitle_PayrollAdministrator = "Payroll Administrator";
    public static final String jobTitle_PreSalesCoordinator = "Pre-Sales Coordinator";
    public static final String jobTitle_QAEngineer = "QA Engineer";
    public static final String jobTitle_QALead = "QA Lead";
    public static final String jobTitle_SalesRepresentative = "Sales Representative";
    public static final String jobTitle_SocialMediaMarketer = "Social Media Marketer";
    public static final String jobTitle_SoftwareArchitect = "Software Architect";
    public static final String jobTitle_SoftwareEngineer = "Software Engineer";
    public static final String jobTitle_SupportSpecialist = "Support Specialist";
    public static final String jobTitle_VPClientServices = "VP - Client Services";
    public static final String jobTitle_VPSalesAndMarketing = "VP - Sales & Marketing";
    public EmployeeList selectJobTitle(String option) {
        jobTitleField.click();
        selectOption(option);
        return this;
    }


    public static final String subUnit_OrangeHRM = "OrangeHRM";
    public static final String subUnit_Administration = "Administration";
    public static final String subUnit_Engineering = "Engineering";
    public static final String subUnit_Development = "Development";
    public static final String subUnit_QualityAssurance = "Quality Assurance";
    public static final String subUnit_TechOps = "TechOps";
    public static final String subUnit_SalesAndMarketing = "Sales & Marketing";
    public static final String subUnit_Sales = "Sales";
    public static final String subUnit_Marketing = "Marketing";
    public static final String subUnit_ClientServices = "Client Services";
    public static final String subUnit_TechnicalSupport = "Technical Support";
    public static final String subUnit_Finance = "Finance";
    public static final String subUnit_HumanResources = "Human Resources";
    public EmployeeList selectSubUnit(String option) {
        subUnitField.click();
        selectOption(option);
        return this;
    }

    public EmployeeList enterEmployeeName(String name) {
        empNameField.sendKeys(name);
        return this;
    }

    public EmployeeList enterEmployeeId(String id) {
        empIdField.sendKeys(id);
        return this;
    }

    public EmployeeList enterSupervisorName(String supervisorName) {
        supervisorNameField.sendKeys(supervisorName);
        selectDynamicOptions(supervisorName);
        return this;
    }

    public EmployeeList clickSearch() {
        searchButton.click();
        return this;
    }

    public EmployeeList clickReset() {
        try{
            resetButton.click();
        }
        catch(Exception ex) {
            clickReset();
        }
        return this;
    }

    public int noOfPages() {
        return pageNoButtonList.size();
    }

    public int getTotalEmployeeVisible() throws InterruptedException {
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
                if(dataRowFirstName.get(j).getText().toLowerCase().contains(name.toLowerCase())){
                    matchingEmp++;
                }
                else if(dataRowLastName.get(j).getText().toLowerCase().contains(name.toLowerCase())){
                    matchingEmp++;
                }
                else if((dataRowFirstName.get(j).getText() + " " + dataRowLastName.get(j).getText()).toLowerCase().contains(name.toLowerCase())) {
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

    public EmployeeList clickDeleteEmpoyeeId(String empId) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if (dataRowId.get(j).getText().equalsIgnoreCase(empId)) {
                    dataRowDelete.get(j).click();
                    return this;
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
        return this;
    }

    public EmployeeList confirmDeleteYes(){
        try{
            deleteConfirmation.click();
            return this;
        }
        catch(Exception ex){
            return this;
        }
    }

    public EmployeeList cancelDeleteNo(){
        try{
            deleteCancel.click();
            return this;
        }
        catch(Exception ex){
            return this;
        }
    }

    public boolean getEmployeeIdAvailable(String empId) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowId.get(j).getText().equalsIgnoreCase(empId)) {
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

    public String getEmployeeIdFirstName(String empId) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowId.get(j).getText().equalsIgnoreCase(empId)) {
                    String firstName = dataRowFirstName.get(j).getText();
                    if(pageNoButtonList.size() != 0) {
                        pageNoButtonList.get(0).click();
                    }
                    return firstName;
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

    public String getEmployeeIdLastName(String empId) throws InterruptedException {
        int tempi;
        for(int i = 0; i<pageNoButtonList.size() || i==0; i++) {
            Thread.sleep(2000);
            for(int j = 0; j< dataRow.size(); j++) {
                if(dataRowId.get(j).getText().equalsIgnoreCase(empId)) {
                    String lastName = dataRowLastName.get(j).getText();
                    if(pageNoButtonList.size() != 0) {
                        pageNoButtonList.get(0).click();
                    }
                    return lastName;
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

    public void editEmployeeId(String empId) throws InterruptedException {
        int tempi;
        for (int i = 0; i < pageNoButtonList.size() || i == 0; i++) {
            Thread.sleep(2000);
            for (int j = 0; j < dataRow.size(); j++) {
                if (dataRowId.get(j).getText().equalsIgnoreCase(empId)) {
                    dataRowEdit.get(j).click();
                    return;
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

    public EmployeeList goToPage(int pgNumber) {
        if (pageNoButtonList.size() != 0 || pgNumber<=pageNoButtonList.size()) {
            pageNoButtonList.get(pgNumber - 1).click();
        }
        return this;
    }
}
