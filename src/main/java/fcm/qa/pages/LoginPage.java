package fcm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fcm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@id='login']")
	WebElement userEmail;

	@FindBy(xpath = "//input[@id='password']")
	WebElement userPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//a[contains(text(),'Reset Password')]")
	WebElement forgetPass;

	// Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String un, String pwd) {
		userEmail.sendKeys(un);
		userPassword.sendKeys(pwd);
		submit.click();

		return new HomePage();
	}
	
	public boolean forgetPassLink() {
		return forgetPass.isDisplayed();
	}
}
