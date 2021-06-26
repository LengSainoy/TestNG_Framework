package TestCases;

import MyUtil.*;
import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Admin_test extends AdminTest_Base {
   LoginPage loginPage = new LoginPage();
   DashboardPage dashboardPage = new DashboardPage();
   AddAdminPage addAdminPage = new AddAdminPage();
   AdminPage adminPage = new AdminPage();
   final WebDriver driver = Driver.getDriver();

   @Test
   public void php101() {
      driver.get(ConfigurationReader.getProperty("admin_url"));
      loginPage.login(ConfigurationReader.getProperty("admin_user")
         , ConfigurationReader.getProperty("admin_pswd"));
      BrowserUtility.wait(3);
      String act_pageTitle = driver.getTitle();
      Assert.assertEquals(act_pageTitle, ConfigurationReader.getProperty("dashboardTitle"));
   }

   @Test(dependsOnMethods = "php101")
   public void php102() {
      dashboardPage.accountButton.click();
      dashboardPage.adminsButton.click();
      BrowserUtility.wait(2);
      String act_pageTitle = driver.getTitle();
      Assert.assertEquals(act_pageTitle, ConfigurationReader.getProperty("adminsManagement"));

      adminPage.addButton.click();

      addAdminPage.fillForm(
         ConfigurationReader.getProperty("regis_firstName"),
         ConfigurationReader.getProperty("regis_lastName"),
         ConfigurationReader.getProperty("regis_email"),
         ConfigurationReader.getProperty("regis_password"),
         ConfigurationReader.getProperty("regis_mobile"),
         ConfigurationReader.getProperty("regis_country"),
         ConfigurationReader.getProperty("regis_address")
      );
      addAdminPage.submitButton.click();

      String act_name = adminPage.verifyAddName.getText();
      Assert.assertEquals(act_name, ConfigurationReader.getProperty("regis_firstName"));
   }

   @Test(priority = 1)
   public void php103() {
      driver.get(ConfigurationReader.getProperty("admin_url"));
      loginPage.login(ConfigurationReader.getProperty("regis_email")
         , ConfigurationReader.getProperty("regis_password"));

      BrowserUtility.wait(3);
      String act_pageTitle = driver.getTitle();
      Assert.assertEquals(act_pageTitle, ConfigurationReader.getProperty("dashboardTitle"));

   }
}
