package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class CheckoutPage {

    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fn, String ln, String zip) {
        WaitUtils.waitForVisibility(driver, firstName);
        driver.findElement(firstName).sendKeys(fn);
        WaitUtils.waitForVisibility(driver, lastName);
        driver.findElement(lastName).sendKeys(ln);
        WaitUtils.waitForVisibility(driver, postalCode);
        driver.findElement(postalCode).sendKeys(zip);
        WaitUtils.waitForClickable(driver, continueBtn);
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        WaitUtils.waitForClickable(driver, finishBtn);
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        WebElement el = WaitUtils.waitForVisibility(driver, successMsg);
        return el.getText();
    }
    
    
    
}