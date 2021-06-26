package PageObject;

import MyUtil.BrowserUtility;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyUtil.Driver;

public class AddAdminPage {

	public AddAdminPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy (xpath = "//div//div//input[@name='fname']")
	public WebElement firstNameInput;
	
	@FindBy(xpath = "//div//div//input[@name='lname']")
	public WebElement lastNameInput;
	
	@FindBy (xpath = "//div//div//input[@name='email']")
	public WebElement emailInput;
	
	@FindBy(xpath = "//div//div//input[@name='password']")
	public WebElement passwordInput;
	
	@FindBy (xpath = "//div//div//input[@name='mobile']")
	public WebElement mobileInput;
	
	@FindBy (css = "span.select2-arrow")
	public WebElement countryDropdown;
	
	@FindBy (css = "input.select2-input")
	public WebElement countrySendKey;
	
	@FindBy (xpath = "//div//div//input[@name='address1']")
	public WebElement addressInput;
	
@FindBy (xpath = "//button[text()='Submit']")
	public WebElement submitButton;

	public void fillForm(
		String firstName,
		String lastName,
		String email,
		String password,
		String mobile,
		String country,
		String address) {

		firstNameInput.sendKeys(firstName);
		lastNameInput.sendKeys(lastName);
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		mobileInput.sendKeys(mobile);
		countryDropdown.click();
		BrowserUtility.wait(2);
		countrySendKey.sendKeys(country, Keys.ENTER);
		addressInput.sendKeys(address);

	}
}
