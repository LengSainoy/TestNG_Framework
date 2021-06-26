package PageObject;

import MyUtil.Driver;
import TestCases.AdminTest_Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends AdminTest_Base {

   public AdminPage() {

      PageFactory.initElements(Driver.getDriver(), this);
   }

   @FindBy(xpath = "//form//button[@type='submit']")
   public WebElement addButton;
   @FindBy(xpath = "//table//tr[1]/td[3]")
   public WebElement verifyAddName;
   @FindBy(xpath = "//table//tr[1]/td[5]")
   public WebElement verifyEmail;
}
