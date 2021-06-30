package TestCases;

import MyUtil.ConfigurationReader;
import PageObject.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseClass {
   WebDriver driver;
   DashboardPage dashboardPage = new DashboardPage();

   @BeforeSuite
   public WebDriver getDriver() {
      if (driver == null) {
         String browser = System.getProperty("browser") != null ?
                             System.getProperty("browser") :
                             ConfigurationReader.getProperty("browser");
         switch (browser) {
            case "firefox" -> {
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
            }
            case "chrome" -> {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
            }
            case "edge" -> {
               WebDriverManager.edgedriver().setup();
               driver = new EdgeDriver();
            }
            case "headless" -> {
               DesiredCapabilities caps = new DesiredCapabilities();
               caps.setJavascriptEnabled(true);
               WebDriverManager.phantomjs().setup();
               driver = new PhantomJSDriver(caps);
            }
         }
      }
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      return driver;

   }

   @BeforeClass
   public void init() {
      driver.get(ConfigurationReader.getProperty("admin_url"));
      driver.manage().deleteAllCookies();
   }

   @AfterClass
   public void tearDown() {
      driver.close();
   }

   @AfterMethod
   public void logout() {
      dashboardPage.logoutBtn.click();
   }
}
