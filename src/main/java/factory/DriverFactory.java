package factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import utilities.TestUtils;

import java.util.logging.Logger;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final Logger logger = Logger.getLogger(DriverFactory.class.getName());

    public static WebDriver initDriver() {

        String browser = TestUtils.getProperty("browser");

        if (browser == null || browser.isEmpty()) {
            logger.severe("Browser property not set in config.properties");
            throw new RuntimeException("Browser property not set in config.properties");
        }

        WebDriver driver;
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                logger.info("Chrome browser initialized successfully.");
            } else if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("Edge browser initialized successfully.");
            } else {
                logger.severe("Browser not supported: " + browser);
                throw new RuntimeException("Browser not supported: " + browser);
            }
            driver.manage().window().maximize();
            tlDriver.set(driver);
        } catch (Exception e) {
            logger.severe("Failed to initialize the browser: " + e.getMessage());
            throw new RuntimeException("Failed to initialize the browser", e);
        }
        return tlDriver.get();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Browser closed successfully.");
            } catch (Exception e) {
                logger.warning("Failed to close the browser: " + e.getMessage());
            } finally {
                tlDriver.remove();
            }
        }
    }
}