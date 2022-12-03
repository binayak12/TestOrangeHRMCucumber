package navigate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Menu {
	WebDriver driver;
	int waitTime = 15;

	public Menu(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	@FindBy(css = "span.oxd-main-menu-item--name")
	private List<WebElement> mainMenuList;
	
	@FindBy(css = ".oxd-topbar-body-nav-tab-item")
	private List<WebElement> topMenu;
	
	@FindBy(css = ".oxd-topbar-body-nav-tab-link")
	private List<WebElement> dropMenu;

	
	public Menu clickOn(String button) {
			for (int i = 0; i < mainMenuList.size(); i++) {
				if (button.equalsIgnoreCase(mainMenuList.get(i).getText())) {
					mainMenuList.get(i).click();
					return this;
				}
			}
			for (int i = 0; i < topMenu.size(); i++) {
				if (button.equalsIgnoreCase(topMenu.get(i).getText())) {
					topMenu.get(i).click();
					return this;
				}
			}

			for (int i = 0; i < dropMenu.size(); i++) {
				if (button.equalsIgnoreCase(dropMenu.get(i).getText())) {
					dropMenu.get(i).click();
					return this;
				}
		}
		return this;
	}

	
	
	public Menu clickOnAdmin() {
		clickOn("Admin");
		return this;
	}
	
	public Menu clickOnPIM() {
		clickOn("PIM");
		return this;
	}

	public Menu clickOnLeave() {
		clickOn("Leave");
		return this;
	}

	public Menu clickOnTime() {
		clickOn("Time");
		return this;
	}
	
	public Menu clickOnRecruitment() {
		clickOn("Recruitment");
		return this;
	}

	public Menu clickOnMyInfo() {
		clickOn("My Info");
		return this;
	}
	
	public Menu clickOnDashboard() {
		clickOn("Dashboard");
		return this;
	}
	
	public Menu clickOnDirectory() {
		clickOn("Directory");
		return this;
	}
}
