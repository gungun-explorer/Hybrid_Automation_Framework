package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "dataset1")
    public void loginTest(String user, String pass) {

        LoginPage login = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login.enterUsername(user);
        login.enterPassword(pass);
        login.clickLogin();

        HomePage home = new HomePage(driver);
        wait.until(ExpectedConditions.visibilityOf(home.getHomePageElement()));
        Assert.assertTrue(home.isHomePageDisplayed());
    }

    @DataProvider(name = "dataset1")
    public Object[][] dataset1() {
        return new Object[][] {
            {"standard_user", "secret_sauce"},
            {"locked_out", "secret_sauce"},
            {"problem_user", "secret_sauce"},
            {"performance_glitch_user", "secret_sauce"}
        };
    }

}