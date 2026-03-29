package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class HomePage {

    WebDriver driver;

    By productsTitle = By.className("title");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageDisplayed() {
        WebElement el = WaitUtils.waitForVisibility(driver, productsTitle);
        return el.isDisplayed();
    }

    public WebElement getHomePageElement() {
        return WaitUtils.waitForVisibility(driver, productsTitle);
    }
}