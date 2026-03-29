package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestUtils;

public class CheckoutTests extends BaseTest {

    @Test
    public void completeOrderTest() {

        LoginPage login = new LoginPage(driver);
        login.enterUsername(TestUtils.getProperty("username"));
        login.enterPassword(TestUtils.getProperty("password"));
        login.clickLogin();

        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        product.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterDetails("Zeni", "Automation", "560001");
        checkout.finishOrder();

        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
    }
}