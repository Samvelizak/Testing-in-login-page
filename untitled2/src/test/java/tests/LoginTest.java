package tests;


import Page.LoginPage;
import com.aventstack.extentreports.Status;
import extentreport.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.io.IOException;


public class LoginTest extends BaseTest {




    @DataProvider(name = "loginData")
    public Object[][] getData() throws IOException{
        String excelFilePath ="E:\\tasks\\untitled2\\files\\Book1.xlsx";
        String  sheetName="Sheet1";
        return ExcelUtils.getExcelData(excelFilePath,sheetName);
    }


    @Test(dataProvider = "loginData")
    public void testcase(String username, String password, String expectedTitle){
        test = extent.createTest("Login Test with Data: " + username + " / " + password, "Test to verify login functionality");

        // Perform test steps
        LoginPage objlp = new LoginPage(driver);
        String res = objlp.login(username, password);

        // Log test result
        if (res.equals(expectedTitle)) {
            test.pass("Login successful with username: " + username);
        } else {
            test.fail("Login failed with username: " + username);
        }

        // Assertion
        Assert.assertEquals(res,  expectedTitle);
    }

    }


