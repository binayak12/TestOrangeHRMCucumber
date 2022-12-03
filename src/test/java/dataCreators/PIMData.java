package dataCreators;

import org.openqa.selenium.WebElement;

public class PIMData {
    private WebElement selectElement;
    private String id;
    private String firstName;
    private String lastName;
    private WebElement deleteElement;


    public WebElement getSelectElement() {
        return selectElement;
    }

    public void setSelectElement(WebElement selectElement) {
        this.selectElement = selectElement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public WebElement getDeleteElement() {
        return deleteElement;
    }

    public void setDeleteElement(WebElement deleteElement) {
        this.deleteElement = deleteElement;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
