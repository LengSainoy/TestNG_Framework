package TestCases;

import MyUtil.ConfigurationReader;
import MyUtil.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class SupplierTest_Base {
      final WebDriver driver = Driver.getDriver();
   @BeforeClass
   public void init() {
      driver.get(ConfigurationReader.getProperty("supplier_url"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      driver.manage().deleteAllCookies();
   }

   @AfterClass
   public void tearDown() {
      driver.quit();
   }
}
