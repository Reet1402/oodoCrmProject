package fcm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import fcm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[@class='d-none d-xl-inline-flex gap-1']//button[@type='button'][contains(text(),'New')]")
	WebElement newContact;

	@FindBy(xpath = "//input[@id='radio_field_0_person']")
	WebElement radio;

	@FindBy(xpath = "//input[@id='name_1']")
	WebElement con_Name;

	@FindBy(xpath = "//input[@id='parent_id_0']")
	WebElement com_Name;

	@FindBy(xpath = "//select[@id='type_0']")
	WebElement dropDown;

	@FindBy(xpath = "//input[@id='function_0']")
	WebElement job_Pos;

	@FindBy(xpath = "//input[@id='phone_0']")
	WebElement phone_No;

	@FindBy(xpath = "//input[@id='mobile_0']")
	WebElement mobile_No;

	@FindBy(xpath = "//input[@id='email_0']")
	WebElement email_Add;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	WebElement add_Con;

	@FindBy(xpath = "//button[@class='btn btn-primary o_form_button_save']")
	WebElement saveClose;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public void createContact(String name, String comName, String jp, String phone1, String phone2,
			String emailAddress) {
		newContact.click();
		radio.click();
		con_Name.sendKeys(name);
		com_Name.sendKeys(comName + Keys.ENTER);
		// drop down menu
		Select s = new Select(dropDown);
		s.selectByIndex(2);

		job_Pos.sendKeys(jp);
		phone_No.sendKeys(phone1);
		mobile_No.sendKeys(phone2);
		email_Add.sendKeys(emailAddress);
		add_Con.click();
		saveClose.click();

	}

	public void closeBrowser() {
		driver.quit();
	}

}
