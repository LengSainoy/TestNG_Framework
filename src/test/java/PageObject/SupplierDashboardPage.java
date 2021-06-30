package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SupplierDashboardPage extends BaseClass {
   public SupplierDashboardPage() {
      PageFactory.initElements(getDriver(), this);
   }

   // Store locator of each page here.
   @FindBy(xpath = "//ul[@id='social-sidebar-menu']/li")
   List<WebElement> sidetab_Menus;

   @FindBy(linkText = "DASHBOARD")
   public WebElement header_Dashboard;

   public void verifySideTabMenus(List<String> expectedList) {
      for (int i = 0; i < sidetab_Menus.size(); i++) {
         Assert.assertTrue(sidetab_Menus.get(i).getText().contains(expectedList.get(i)));
      }
   }
}

