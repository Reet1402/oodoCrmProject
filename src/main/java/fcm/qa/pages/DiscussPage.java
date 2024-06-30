package fcm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fcm.qa.base.TestBase;

public class DiscussPage extends TestBase {

	@FindBy(xpath = "//i[@title='Start a conversation']")
	WebElement plus;

	@FindBy(xpath = "//input[@placeholder='Start a conversation']")
	WebElement findContact;

	@FindBy(xpath = "//strong[contains(text(),'reet pate')]")
	WebElement clickName;

	@FindBy(xpath = "//input[@placeholder='Press Enter to start']")
	WebElement enter;

	@FindBy(xpath = "//textarea[@placeholder='Message reet pate…']")
	WebElement writeMsg;

	@FindBy(xpath = "//button[@aria-label='Send']")
	WebElement sendMsg;

	public DiscussPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public boolean sendMessage(String name, String msg) {
		plus.click();
		findContact.sendKeys(name);
		clickName.click();
		enter.sendKeys(Keys.RETURN);
		writeMsg.sendKeys(msg);
		sendMsg.click();
		WebElement sentMessage = driver.findElement(By.xpath("//p[contains(text(),'"+msg+"')]"));
		return sentMessage.isDisplayed();
	}

	public void closeBrowser() {
		driver.quit();
	}

}
