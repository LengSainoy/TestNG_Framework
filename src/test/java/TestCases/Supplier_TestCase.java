package TestCases;

import MyUtil.ConfigurationReader;
import MyUtil.ListenerTestNG;
import PageObject.*;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;

@Listeners(ListenerTestNG.class)
public class Supplier_TestCase extends BaseClass {
   DemoPage demoPage = new DemoPage();
   LoginPage loginPage = new LoginPage();
   DashboardPage dashboardPage = new DashboardPage();
   SupplierDashboardPage supplierBoard = new SupplierDashboardPage();

   @BeforeMethod
   public void loginAsSupplier() {
      demoPage.btn_SupplierLink.click();
      loginPage.login(ConfigurationReader.getProperty("supplier_user"),
         ConfigurationReader.getProperty("supplier_pswd"));
   }



   @Test(description = "verify sidetab-menus has menus as expected")
   public void php201() {
      var expectedMenus = new ArrayList<>(
         Arrays.asList("dashboard", "tours", "locations", "bookings", "widgets"));
      supplierBoard.verifySideTabMenus(expectedMenus);

   }
}


