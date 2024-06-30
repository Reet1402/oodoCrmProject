package fcm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fcm.qa.base.TestBase;
import fcm.qa.pages.HomePage;
import fcm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		openBrowser();
		loginPage = new LoginPage();
	}

	@Test
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test
	public void forgetPassLinkTest() {
		Assert.assertTrue(loginPage.forgetPassLink());
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
