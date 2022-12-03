package tester;


import org.openqa.selenium.*;
import org.sikuli.script.FindFailed;
import utils.BrowserFactory;
import utils.Pages;

import java.awt.*;

public class TryCode {
    public static void main(String args[]) throws InterruptedException, AWTException, FindFailed {
        WebDriver driver = BrowserFactory.getDriver();
        Pages.loginPage().getToLoginPage();
        Pages.loginPage().enterUsername();
        Pages.loginPage().enterPassword();
        Pages.loginPage().clickLoginBtn();

        Pages.menu().clickOn("PIM");
        Pages.menu().clickOn("Add Employee");

        Pages.addEmployee().enterFirstName("Binayak").enterLastName("Sadhukhan").enterEmpId("Test").clickSave();

    }
}