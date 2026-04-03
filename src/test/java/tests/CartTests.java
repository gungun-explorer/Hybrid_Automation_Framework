package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestUtils;

public class CartTests extends BaseTest {

    @Test
    public void checkoutFromCartTest() {

 
        LoginPage login = new LoginPage(driver);
        login.enterUsername(TestUtils.getProperty("username"));
        login.enterPassword(TestUtils.getProperty("password"));
        login.clickLogin();

        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        product.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        System.out.println("Cart Test Executed Successfully");
    }
}