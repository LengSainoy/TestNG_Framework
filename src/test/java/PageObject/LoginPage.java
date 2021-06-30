package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }
    //Store locator of each page here
    @FindBy (xpath = "//label/input[@name='email']")
    WebElement input_Email;
    @FindBy (xpath = "//label/input[@type='password']")
    WebElement input_Password;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement btn_Submit;

    public void login(String user, String pswd) {
        input_Email.clear();
        input_Email.sendKeys(user);
        input_Password.clear();
        input_Password.sendKeys(pswd);
        btn_Submit.click();
    }


}
