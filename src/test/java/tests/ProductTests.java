package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestUtils;

public class ProductTests extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage login = new LoginPage(driver);
        login.enterUsername(TestUtils.getProperty("username"));
        login.enterPassword(TestUtils.getProperty("password"));
        login.clickLogin();

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isHomePageDisplayed());

        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        product.goToCart();
    }
}