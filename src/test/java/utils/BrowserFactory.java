package utils;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserFactory {

    private static WebDriver driver;
    private static String defaultBrowser = "Chrome";

    public static boolean notStarted = true;

    private static void startDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                startDriver(defaultBrowser);
                break;
        }
        notStarted = false;
    }

    public static WebDriver getDriver() {

        if(notStarted) {
            Properties websiteDetails = new Properties();
            try {
                websiteDetails.load(BrowserFactory.class.getClassLoader().getResourceAsStream("browserDetails.property"));
            } catch (IOException e) {
                System.out.println("File not Loading");
                driver = getDriver(defaultBrowser);
                driver.manage().window().maximize();
                return driver;
            }
            String browserName = websiteDetails.get("browserName").toString();
            startDriver(browserName);
        }
        return driver;
    }

    public static WebDriver getDriver(String browser) {
        if(notStarted) {
            startDriver(browser);
        }

        return driver;
    }
}
