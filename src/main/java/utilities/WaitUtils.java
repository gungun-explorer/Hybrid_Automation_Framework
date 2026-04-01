package utilities;
import java.time.Duration;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class WaitUtils {

    private static final Logger logger = Logger.getLogger(WaitUtils.class.getName());

    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fn, String ln, String zip) {
        try {
            logger.info("Waiting for first name field and entering value");
            WaitUtils.waitForVisibility(driver, firstName);
            driver.findElement(firstName).sendKeys(fn);
            logger.info("Waiting for last name field and entering value");
            WaitUtils.waitForVisibility(driver, lastName);
            driver.findElement(lastName).sendKeys(ln);
            logger.info("Waiting for postal code field and entering value");
            WaitUtils.waitForVisibility(driver, postalCode);
            driver.findElement(postalCode).sendKeys(zip);
            logger.info("Waiting for continue button and clicking");
            WaitUtils.waitForClickable(driver, continueBtn);
            driver.findElement(continueBtn).click();
        } catch (Exception e) {
            logger.severe("Error in enterDetails: " + e.getMessage());
            throw e;
        }
    }

    public void finishOrder() {
        try {
            logger.info("Waiting for finish button and clicking");
            WaitUtils.waitForClickable(driver, finishBtn);
            driver.findElement(finishBtn).click();
        } catch (Exception e) {
            logger.severe("Error in finishOrder: " + e.getMessage());
            throw e;
        }
    }

    public String getSuccessMessage() {
        try {
            logger.info("Waiting for success message");
            WebElement el = WaitUtils.waitForVisibility(driver, successMsg);
            String msg = el.getText();
            logger.info("Success message: " + msg);
            return msg;
        } catch (Exception e) {
            logger.severe("Error in getSuccessMessage: " + e.getMessage());
            throw e;
        }
    }

    public static WebElement waitForVisibility(WebDriver driver, By locator) {
        try {
            logger.info("Waiting for visibility of element: " + locator.toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            logger.severe("Element not visible: " + locator.toString() + ", error: " + e.getMessage());
            throw e;
        }
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        try {
            logger.info("Waiting for element to be clickable: " + locator.toString());
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            logger.severe("Element not clickable: " + locator.toString() + ", error: " + e.getMessage());
            throw e;
        }
    }
}