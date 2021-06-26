package PageObject;

import MyUtil.Driver;
import TestCases.SupplierTest_Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierDashboardPage extends SupplierTest_Base {
   public SupplierDashboardPage() {
      PageFactory.initElements(Driver.getDriver(), this);
   }
   // Store locator of each page here.
   @FindBy(xpath = "//a[@href=\"https://www.phptravels.net/supplier\"]")
   public WebElement sidetab_Dashboard;
   @FindBy(xpath = "/html/body/div[3]/nav/div[2]/ul/li[2]/a")
   public WebElement sidetab_Tours;
   @FindBy(xpath = "/html/body/div[3]/nav/div[2]/ul/li[2]/ul/li[1]/a")
   public WebElement subtab_ManageTours;
   @FindBy(xpath = "/html/body/div[3]/nav/div[2]/ul/li[3]/a")
   public WebElement sidetab_Locations;
   @FindBy(xpath="/html/body/div[3]/nav/div[2]/ul/li[3]/ul/li/a")
   public WebElement subtab_Locations;
   @FindBy(xpath = "/html/body/div[3]/nav/div[2]/ul/li[4]/a")
   public WebElement sidetab_Booking;
   @FindBy(xpath = "/html/body/div[3]/nav/div[2]/ul/li[5]/a")
   public WebElement sidetab_Widgets;
   @FindBy(linkText = "DASHBOARD")
   public WebElement header_Dashboard;
}

