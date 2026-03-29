package pages;

import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        // Logic to add a product to the cart
    }

    public void goToCart() {
        // Logic to navigate to the cart
    }
}