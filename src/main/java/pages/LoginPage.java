package pages;

import org.openqa.selenium.*;
import utilities.WaitUtils;

public class LoginPage {

    WebDriver driver;

    By user = By.id("user-name");
    By pass = By.id("password");
    By login = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String u) {
        WaitUtils.waitForVisibility(driver, user);
        driver.findElement(user).clear();
        driver.findElement(user).sendKeys(u);
    }

    public void enterPassword(String p) {
        WaitUtils.waitForVisibility(driver, pass);
        driver.findElement(pass).clear();
        driver.findElement(pass).sendKeys(p);
    }

    public void clickLogin() {
        WaitUtils.waitForClickable(driver, login);
        driver.findElement(login).click();
    }
}