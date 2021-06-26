package MyUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BrowserUtility {
    private static final Actions actions = new Actions(Driver.getDriver());

    public static void wait(int timeInSec) {
        try {
            Thread.sleep(timeInSec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }
    public static void switchToWindow(Integer tab) {
        ArrayList<String> tabs = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        try {
            Driver.getDriver().switchTo().window(tabs.get(tab));
        }
        catch (Exception e) {
            System.out.println("Tab: " + tab + " not found!");
        }
    }
    public static String fn_TakeSnapshot(WebDriver driver, String DestFilePath) throws IOException {
        // String TS=fn_GetTimeStamp();
        TakesScreenshot tss = (TakesScreenshot) driver;
        File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
        // DestFilePath=DestFilePath+TS+".png";
        File DestFileObj = new File(DestFilePath);
        FileUtils.copyFile(srcfileObj, DestFileObj);
        return DestFilePath;
    }
    public static void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }
    public static void dragAndDrop(WebElement source, WebElement target) {
        actions.dragAndDrop(source, target).perform();
    }
    public static void doubleClick(WebElement source) {
        actions.doubleClick(source).perform();
    }
    /**
     * return a list of string from a list of elements ignores any element with no
     * text
     *
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<String>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<String>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }
    public static WebElement waitForVisibility(WebElement element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }
    public static WebElement fluentWait(final Object object, int timeInSec) {
        FluentWait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(timeInSec, TimeUnit.SECONDS).pollingEvery(timeInSec, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(driver -> (WebElement) object);
        return element;
    }
}
