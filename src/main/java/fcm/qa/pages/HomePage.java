package fcm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fcm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[@id='result_app_0']")
	WebElement discuss;

	@FindBy(xpath = "//a[@id='result_app_1']")
	WebElement calender;

	@FindBy(xpath = "//a[@id='result_app_2']")
	WebElement contacts;

	@FindBy(xpath = "//a[@id='result_app_3']")
	WebElement crm;

	@FindBy(xpath = "//a[@id='result_app_4']")
	WebElement dashboards;

	@FindBy(xpath = "//a[@id='result_app_5']")
	WebElement apps;

	@FindBy(xpath = "//a[@id='result_app_6']")
	WebElement settings;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public DiscussPage clickOnDiscussLink() {

		discuss.click();
		return new DiscussPage();
	}

	public CalenderPage clickOnCalenderLink() {

		calender.click();
		return new CalenderPage();
	}

	public ContactsPage clickOnContactsLink() {

		contacts.click();
		return new ContactsPage();
	}

	public boolean validateCrmLink() {
		return crm.isDisplayed();
	}

	public boolean validateDashBoardsLink() {
		return dashboards.isDisplayed();
	}

	public boolean validateAppsLink() {
		return apps.isDisplayed();
	}

	public boolean validateSettingsLink() {
		return settings.isDisplayed();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
