package MyUtil;

import org.openqa.selenium.By;

public class Fake {
    public static String getFakeEmail() throws InterruptedException {
        Driver.getDriver().get("https://temp-mail.org/en/");
        Thread.sleep(5000);
        String tempEmail = Driver.getDriver().findElement(By.cssSelector("input#mail")).getAttribute("value");
        Driver.getDriver().navigate().back();
        Thread.sleep(2000);
        return tempEmail;
    }
}
