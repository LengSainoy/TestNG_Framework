package PageObject;

import TestCases.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoPage extends BaseClass {
   public DemoPage() {
      PageFactory.initElements(getDriver(), this);
   }

   @FindBy(xpath = "(//div[@class='col-md-12 form-group']/div)[3]")
   public WebElement btn_SupplierLink;
   @FindBy(xpath = "(//div[@class='col-md-12 form-group']/div)[2]")
   public WebElement btn_AdminLink;
}
