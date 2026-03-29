package base;

import factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import utilities.TestUtils;

public class BaseTest {

    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {

        driver = DriverFactory.initDriver();

        if (driver == null) {
            throw new RuntimeException("Driver is NULL ❌");
        }

        driver.manage().window().maximize();
        driver.get(TestUtils.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}