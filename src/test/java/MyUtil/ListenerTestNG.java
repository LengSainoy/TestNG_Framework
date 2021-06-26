package MyUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ListenerTestNG implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test <"+ result.getName()+"> Start");
        System.out.println("==============STARTED===============");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("==============FINISHED==============");
        System.out.println("Test <"+result.getName()+"> Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
        String methodName = result.getName();
        File destFile = null;
        if (!result.isSuccess()) {
            File scrFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
                        + "/target/surefire-reports";
                destFile = new File((String) reportDirectory + "/failure_screenshots/"
                        + methodName + "_"
                        + formatter.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='" + destFile.getAbsolutePath()
                        + "'> <img src='" + destFile.getAbsolutePath()
                        + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        assert destFile != null;
        System.out.println("Screenshot has been taken at : "+formatter.format(calendar.getTime())+
                "Located at "+destFile.getAbsolutePath());
    }
}
