package listeners;

import base.BaseTest;
import org.testng.*;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object obj = result.getInstance();

        if (obj instanceof BaseTest) {
            BaseTest base = (BaseTest) obj;
            ScreenshotUtils.captureScreenshot(base.getDriver(), result.getName());
        }
    }
}