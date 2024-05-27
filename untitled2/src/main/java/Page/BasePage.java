package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage  {
    protected static WebDriver driver;
    private static final int TIMEOUT_SECONDS = 10;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to find element and send keys
    public void find(By locator, String input) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ele.sendKeys(input);
    }

    // Method to click an element
    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.click();
    }


    public String getTop(){
        return driver.getTitle();
    }
}
