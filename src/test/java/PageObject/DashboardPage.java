package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BaseClass {
   public DashboardPage() {
      PageFactory.initElements(getDriver(), this);
   }
   @FindBy(xpath = "//i[@class='fa fa-user-circle']")
   WebElement accountButton;
   @FindBy(xpath = "//ul[@id='ACCOUNTS']/li[1]")
   WebElement adminsButton;
   @FindBy(css = "i.fa.fa-sign-out")
   public WebElement logoutBtn;

   public void click_AccountAdmin() {
     accountButton.click();
     adminsButton.click();
   }

   public void verifyTitle(String expectedTitle) {
      String act_pageTitle = getDriver().getTitle();
      Assert.assertEquals(act_pageTitle, expectedTitle);
   }
}
