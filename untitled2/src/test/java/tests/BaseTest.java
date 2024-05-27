package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import extentreport.ExtentReport;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest extends ExtentReport {
    protected static WebDriver driver;

    protected ITestResult result;



    @BeforeSuite
    public void setUp(){

        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://testphp.vulnweb.com/login.php");

    }

    @BeforeMethod
    public void slow(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    @AfterClass
    public  void tearDown(){
        if (driver != null) {
            driver.quit();
        }
        captureScreenshotOnFailure( result);



    }


    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + result.getName() + ".png";
            Path path = Paths.get(screenshotPath);
            try {
                Files.createDirectories(path.getParent());
                Files.copy(srcFile.toPath(), path);
                test.addScreenCaptureFromPath(path.toString(), result.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
