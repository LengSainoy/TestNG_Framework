package TestCases;

import MyUtil.*;
import PageObject.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ListenerTestNG.class)
public class Admin_TestCase extends BaseClass {
   LoginPage loginPage = new LoginPage();
   DashboardPage dashboardPage = new DashboardPage();
   AdminPage adminPage = new AdminPage();
   final WebDriver driver = getDriver();
   Faker faker = new Faker();
   String randomEmail = faker.name() + "gmail.com";

   @BeforeMethod
   public void loginAsAdmin() {
      driver.get(ConfigurationReader.getProperty("admin_url"));
      loginPage.login(ConfigurationReader.getProperty("admin_user")
         , ConfigurationReader.getProperty("admin_pswd"));
      BrowserUtility.wait(2);
   }

   @Test
   public void php101() {
      dashboardPage.verifyTitle(ConfigurationReader.getProperty("dashboardTitle"));
   }

   @Test (dependsOnMethods = "php101")
   public void php102() {
      dashboardPage.click_AccountAdmin();
      BrowserUtility.waitForPageToLoad(2);

      dashboardPage.verifyTitle(ConfigurationReader.getProperty("adminsManagementTitle"));

      adminPage.addNewAdmin(
         ConfigurationReader.getProperty("regis_firstName"),
         ConfigurationReader.getProperty("regis_lastName"),
         randomEmail,
         ConfigurationReader.getProperty("regis_password"),
         ConfigurationReader.getProperty("regis_mobile"),
         ConfigurationReader.getProperty("regis_country"),
         ConfigurationReader.getProperty("regis_address")
      );

      String act_name = BrowserUtility.waitForVisibility(adminPage.verifyAddedName, 5).getText();
      System.out.println(act_name);
      Assert.assertEquals(act_name, ConfigurationReader.getProperty("regis_firstName"));

      String act_email = adminPage.verifyEmail.getText();
      System.out.println(act_email);
      Assert.assertEquals(act_email, ConfigurationReader.getProperty("regis_email"));

      dashboardPage.logoutBtn.click();

      driver.get(ConfigurationReader.getProperty("admin_url"));
      loginPage.login(ConfigurationReader.getProperty("regis_email")
         , ConfigurationReader.getProperty("regis_password"));

      BrowserUtility.waitForPageToLoad(3);
      String act_pageTitle = driver.getTitle();
      Assert.assertEquals(act_pageTitle, ConfigurationReader.getProperty("dashboardTitle"));
      dashboardPage.logoutBtn.click();
   }
}
