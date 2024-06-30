package fcm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fcm.qa.base.TestBase;
import fcm.qa.pages.ContactsPage;
import fcm.qa.pages.HomePage;
import fcm.qa.pages.LoginPage;
import fcm.qa.testdata.DataFile;

public class ContactsPageTest extends TestBase {

	DataFile dataFile;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		loginPage = new LoginPage();
		dataFile = new DataFile();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 1)
	public void validatePageTitleTest() throws InterruptedException {
		Thread.sleep(2000);
		String s = contactsPage.validatePageTitle();
		Assert.assertEquals(s, "Contacts", "Page Title Not Found");
	}

	@Test(priority = 2)
	public void createContactTest() {
		contactsPage.createContact(dataFile.name, dataFile.companyName, dataFile.jobPosition, dataFile.phone,
				dataFile.mobile, dataFile.emailD);
	}

	@AfterMethod
	public void closeCalenederPage() {
		contactsPage.closeBrowser();
	}
}
