package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class KeywordEngine {
    private WebDriver driver;
    private Map<String, String>testData = new HashMap<>();

    public void executeTest(String csvFilePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
        String line;
        boolean isFirstLine = true;
        while ((line = reader.readLine()) != null) {
            if (isFirstLine) { isFirstLine = false; continue; }
            String[] parts = line.split(",");
            String keyword = parts[2].trim();
            String locatorType = parts[3].trim();
            String locatorValue = parts[4].trim();
            String data = parts.length > 5 ? parts[5].trim() : "";
            runStep(keyword, locatorType, locatorValue, data);
        }
        reader.close();
    }

    private void runStep(String keyword, String locatorType, String locatorValue, String data) throws Exception {
        switch (keyword.toUpperCase()) {
            case "OPEN_BROWSER":
                driver = new ChromeDriver();
                break;
            case "NAVIGATE":
                driver.get(locatorValue);
                break;
            case "TYPE":
                findElement(locatorType, locatorValue).sendKeys(data);
                break;
            case "CLICK":
                findElement(locatorType, locatorValue).click();
                break;
            case "VERIFY_TEXT":
                String actual = findElement(locatorType, locatorValue).getText();
                if (!actual.equals(data)) throw new AssertionError("Text mismatch: expected '" + data + "', got '" + actual + "'");
                break;
            case "CLOSE_BROWSER":
                driver.quit();
                break;
            default:
                throw new UnsupportedOperationException("Unknown keyword: " + keyword);
        }
    }

    private WebElement findElement(String locatorType, String locatorValue) {
        By by;
        switch (locatorType.toLowerCase()) {
            case "id": by = By.id(locatorValue); break;
            case "name": by = By.name(locatorValue); break;
            case "xpath": by = By.xpath(locatorValue); break;
            case "css": by = By.cssSelector(locatorValue); break;
            case "class": by = By.className(locatorValue); break;
            default: throw new IllegalArgumentException("Unknown locator type: " + locatorType);
        }
        return driver.findElement(by);
    }
}
