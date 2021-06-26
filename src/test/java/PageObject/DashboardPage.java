package PageObject;

import MyUtil.Driver;
import TestCases.AdminTest_Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends AdminTest_Base {
   public DashboardPage() {
      PageFactory.initElements(Driver.getDriver(), this);
   }
   @FindBy(xpath = "//i[@class='fa fa-user-circle']")
   public WebElement accountButton;
   @FindBy(xpath = "//ul[@id='ACCOUNTS']/li[1]")
   public WebElement adminsButton;
   @FindBy(css = "i.fa.fa-sign-out")
   public WebElement signOutBtn;

}
