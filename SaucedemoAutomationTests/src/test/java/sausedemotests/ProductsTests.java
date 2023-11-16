package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.example.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTests extends BaseTest {

    private ProductsPage productsPage;

    @BeforeEach
    public void setup() {
        driver = startBrowser(BrowserTypes.CHROME);
        LoginPage loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
        productsPage.proceedToCheckout();
        productsPage.fillShippingDetails("Jack", "Pott", "8888");
        productsPage.continueCheckout();
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
        productsPage.proceedToCheckout();
        productsPage.fillShippingDetails("Jack", "Pott", "8888");
        productsPage.continueCheckout();
        productsPage.finishCheckout();
        productsPage.navigateBackToProducts();
        productsPage.navigateToShoppingCart();
    }

}
