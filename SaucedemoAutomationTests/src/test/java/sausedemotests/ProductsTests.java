package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.example.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        //assert the number of items in the cart
        Assertions.assertEquals(2, productsPage.getNumberOfItemsInCart(), "Incorrect number of items in the cart");

        //assert that the cart contains the expected product titles
        List<String> productTitles = productsPage.getProductTitlesInCart();
        Assertions.assertTrue(productTitles.contains(Constants.BACKPACK_TITLE), "Backpack title not found in cart");
        Assertions.assertTrue(productTitles.contains(Constants.SHIRT_TITLE), "Shirt title not found in cart");

        //assert the prices of the products
        List<String> productPrices = productsPage.getProductPricesInCart();
        Assertions.assertTrue(productPrices.contains(Constants.BACKPACK_PRICE), "Backpack price not as expected");
        Assertions.assertTrue(productPrices.contains(Constants.SHIRT_PRICE), "Shirt price not as expected");

    }


    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
        productsPage.proceedToCheckout();
        productsPage.fillShippingDetails("Jack", "Pott", "8888");
        productsPage.continueCheckout();

        //to add assertions
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

        //to add assertions
    }

}
