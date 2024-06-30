package fcm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fcm.qa.base.TestBase;
import fcm.qa.pages.CalenderPage;
import fcm.qa.pages.ContactsPage;
import fcm.qa.pages.DiscussPage;
import fcm.qa.pages.HomePage;
import fcm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	DiscussPage discussPage;
	CalenderPage calenderPage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		loginPage = new LoginPage();
		discussPage = new DiscussPage();
		calenderPage = new CalenderPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyHomePageTitle() throws InterruptedException {

		Assert.assertEquals(homePage.validatePageTitle(), "Odoo");
	}

	@Test(priority = 2)
	public void verifyDiscussLink() {

		discussPage = homePage.clickOnDiscussLink();
	}

	@Test(priority = 3)
	public void verifyCalenderLink() {
		calenderPage = homePage.clickOnCalenderLink();
	}

	@Test(priority = 4)
	public void verifyContactsLink() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 5)
	public void verifyCrmLink() {
		Assert.assertTrue(homePage.validateCrmLink());
	}

	@Test(priority = 6)
	public void verifyDashBoardsLink() {
		Assert.assertTrue(homePage.validateDashBoardsLink());
	}

	@Test(priority = 7)
	public void verifyAppsLink() {
		Assert.assertTrue(homePage.validateAppsLink());
	}

	@Test(priority = 8)
	public void verifySettingsLink() {
		Assert.assertTrue(homePage.validateSettingsLink());
	}

	@AfterMethod
	public void closeBrowser() {
		homePage.quitBrowser();
	}
}
