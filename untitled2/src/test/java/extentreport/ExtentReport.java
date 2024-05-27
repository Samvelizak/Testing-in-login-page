package extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReport {
    protected ExtentReports extent;
    protected ExtentTest test;
    @BeforeSuite
    public void setUpExtentReports() {
        // Initialize ExtentReports
        extent = new ExtentReports();
        // Initialize ExtentSparkReporter and attach it to ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("extent.html");
        extent.attachReporter(spark);
    }



    @AfterSuite
    public void flushExtentReports() {
        // Flush ExtentReports
        extent.flush();
    }
}
