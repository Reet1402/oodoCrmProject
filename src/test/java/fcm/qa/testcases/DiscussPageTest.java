package fcm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fcm.qa.base.TestBase;
import fcm.qa.pages.DiscussPage;
import fcm.qa.pages.HomePage;
import fcm.qa.pages.LoginPage;

public class DiscussPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DiscussPage discussPage;

	public DiscussPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		loginPage = new LoginPage();
		discussPage = new DiscussPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		discussPage = homePage.clickOnDiscussLink();

	}

	@Test(priority = 1)
	public void validatePageTitleTest() {

		String s = discussPage.validatePageTitle();
		Assert.assertEquals(s, "Discuss", "Page Title Not Found");
	}

	@Test(priority = 2)
	public void sendMessageTest() {
		boolean a = discussPage.sendMessage(prop.getProperty("name"), prop.getProperty("message"));
		Assert.assertTrue(a);
	}

	@AfterMethod
	public void closeBrowser() {
		discussPage.closeBrowser();
	}
}
