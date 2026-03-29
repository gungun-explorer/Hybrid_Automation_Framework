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

        // 🔹 Step 1: Login
        LoginPage login = new LoginPage(driver);
        login.enterUsername(TestUtils.getProperty("username"));
        login.enterPassword(TestUtils.getProperty("password"));
        login.clickLogin();

        // 🔹 Step 2: Add product to cart
        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        product.goToCart();

        // 🔹 Step 3: Click checkout
        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        System.out.println("Cart Test Executed Successfully ✅");
    }
}