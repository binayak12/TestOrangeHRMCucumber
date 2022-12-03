package stepDefinations;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserFactory;
import utils.Pages;

public class CommonFeatures {
    @Before
    public static void openBrowser(){
        BrowserFactory.getDriver().manage().window().maximize();
    }

    @After
    public static void closeBrowser(){
        BrowserFactory.getDriver().quit();
        BrowserFactory.notStarted = true;
        Pages.setupPending = true;
    }
}
