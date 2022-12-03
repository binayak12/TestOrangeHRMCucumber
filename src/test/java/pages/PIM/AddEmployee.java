package pages.PIM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AddEmployee {

    WebDriver driver;
    Actions act;

    public AddEmployee(WebDriver driver){
        this.driver = driver;
        act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement fNameField;

    @FindBy(name = "middleName")
    private WebElement mNameField;

    @FindBy(name = "lastName")
    private WebElement lNameField;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement empIdField;

    @FindBy(css = "button.oxd-button--secondary")
    private WebElement saveBtn;

    @FindBy(className = "oxd-button--ghost")
    private WebElement cancelBtn;

    public AddEmployee enterFirstName(String firstName){
        fNameField.sendKeys(firstName);
        return this;
    }

    public AddEmployee enterMiddletName(String middleName){
        mNameField.sendKeys(middleName);
        return this;
    }

    public AddEmployee enterLastName(String lastName){
        lNameField.sendKeys(lastName);
        return this;
    }

    public AddEmployee enterEmpId(String empId) {
        try{
            empIdField.click();
            act.keyDown(Keys.CONTROL).keyDown("a").keyUp(Keys.CONTROL).keyUp("a").sendKeys(Keys.BACK_SPACE).sendKeys(empId).build().perform();
        }
        catch(Exception ex){
            System.out.println(ex);
            enterEmpId(empId);
        }
        return this;
    }

    public AddEmployee clickSave(){
        saveBtn.click();
        return this;
    }

    public AddEmployee clickCancel(){
        cancelBtn.click();
        return this;
    }

}
