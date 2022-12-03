package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	String loginPageURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";;
	String username = "Admin";;
	String password = "admin123";;
	Properties websiteDetails;
	int waitTime = 15;



	public LoginPage(WebDriver driver) {
		this.driver = driver;
		websiteDetails  = new Properties();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		//Getting URL, valid username and password from websiteDetails.property
		try {
			FileInputStream file = new FileInputStream("src/test/resources/config/websiteDetails.property");
			try {
				websiteDetails.load(file);
				if(websiteDetails.get("loginURL")!=null)
					loginPageURL = websiteDetails.get("loginURL").toString();
				if(websiteDetails.getProperty("username")!=null)
					username = websiteDetails.getProperty("username").toString();
				if(websiteDetails.getProperty("password")!=null)
					password = websiteDetails.getProperty("password").toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	@FindBy(name = "username")
	private WebElement unameField;
	
	@FindBy(name = "password")
	private WebElement pwdField;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(css = ".oxd-alert-content-text")
	private WebElement errorMessage;
	
	@FindBy(xpath = "//input[@name='password'] /parent::div/following-sibling::span")
	private WebElement unameMessage;
	
	@FindBy(xpath = "//input[@name='username'] /parent::div/following-sibling::span")
	private WebElement passwordMessage;
	

	
	public void enterUsername(String username) {
		
		unameField.sendKeys(Keys.CONTROL+ "A"+Keys.BACK_SPACE);
		unameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		pwdField.sendKeys(Keys.CONTROL+ "A"+Keys.BACK_SPACE);
		pwdField.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void getToLoginPage() {
		driver.get(loginPageURL);
	}
	
	public void enterUsername() {
		enterUsername(username);
	}
	
	public void enterPassword() {
		enterPassword(password);
	}
	
	public String checkErrorMessage() {
		if(driver.getCurrentUrl().equalsIgnoreCase(loginPageURL)) {
			try {
				unameField.click();
				driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
				String errorMsg = errorMessage.getText();
				driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
				return errorMsg;
			}
			catch(NoSuchElementException e) {
				System.out.println(e);
				return null;
			}
		}
		else {
			System.out.println("Not on home page");
			return null;
		}
	}
		
		
		public String checkPasswordMessage() {
			if(driver.getCurrentUrl().equalsIgnoreCase(loginPageURL)) {
				try {
					unameField.click();
					driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
					String unameMsg = unameMessage.getText();
					driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
					return unameMsg;
				}
				catch(NoSuchElementException e) {
					System.out.println(e);
					return null;
				}
			}
			else {
				System.out.println("Not on home page");
				return null;
			}
		}
		
		
			public String checkUsernameMessage() {
				if(driver.getCurrentUrl().equalsIgnoreCase(loginPageURL)) {
					try {
						pwdField.click();
						driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
						String unameMsg = unameMessage.getText();
						driver.manage().timeouts().implicitlyWait(waitTime,TimeUnit.SECONDS);
						return unameMsg;
					}
					catch(NoSuchElementException e) {
						System.out.println(e);
						return null;
					}
				}
				else {
					System.out.println("Not on home page");
					return null;
				}
	}

}
