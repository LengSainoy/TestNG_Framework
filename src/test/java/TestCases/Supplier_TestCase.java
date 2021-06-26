package TestCases;

import MyUtil.*;
import PageObject.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(ListenerTestNG.class)
public class Supplier_TestCase extends SupplierTest_Base {
   LoginPage loginPage = new LoginPage();
   DashboardPage dashboardPage = new DashboardPage();
   SupplierDashboardPage supplierBoard = new SupplierDashboardPage();

   @Test
   public void php201() {
      Driver.getDriver().get(ConfigurationReader.getProperty("supplier_url"));
      loginPage.login(ConfigurationReader.getProperty("supplier_user")
         , ConfigurationReader.getProperty("supplier_pswd"));

      String actualDashBoardTitle = supplierBoard.header_Dashboard.getText();
      String expectedDashBoardTitle = "DASHBOARD";
      assertEquals(actualDashBoardTitle, expectedDashBoardTitle);

      String actualDashBoardTab = supplierBoard.sidetab_Dashboard.getText();
      String expectedDashBoardTab = "DASHBOARD";
      assertEquals(actualDashBoardTab, expectedDashBoardTab);

      String actualToursTab = supplierBoard.sidetab_Tours.getText();
      String expectedToursTab = "TOURS";
      assertEquals(actualToursTab, expectedToursTab);

      String actualLocationsTab = supplierBoard.sidetab_Locations.getText();
      String expectedLocationsTab = "LOCATIONS";
      assertEquals(actualLocationsTab, expectedLocationsTab);

      String actualBookingsTab = supplierBoard.sidetab_Booking.getText();
      String expectedBookingsTab = "BOOKINGS";
      assertEquals(actualBookingsTab, expectedBookingsTab);

      String actualWidgetsTab = supplierBoard.sidetab_Widgets.getText();
      String expectedWidgetsTab = "WIDGETS";
      assertEquals(actualWidgetsTab, expectedWidgetsTab);

      dashboardPage.signOutBtn.click();
   }

}
