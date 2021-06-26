package PageObject;

import MyUtil.Driver;
import org.openqa.selenium.support.PageFactory;

public class ExamplePage {
    public ExamplePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    //Store locator of each page here.



}
