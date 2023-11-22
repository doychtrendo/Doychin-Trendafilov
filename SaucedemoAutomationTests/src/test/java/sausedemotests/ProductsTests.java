package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.example.utils.Constants;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductsTests extends BaseTest {

    private ProductsPage productsPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = startBrowser(BrowserTypes.CHROME);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        driver.get(Constants.BASE_URL);
        loginPage.login(Constants.STANDARD_USER_USERNAME, Constants.STANDARD_USER_PASSWORD);
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
        productsPage.assertNumberOfItemsInCart(2);

        //assert that the cart contains the expected product titles
        productsPage.assertProductTitleInCart(Constants.BACKPACK_TITLE);
        productsPage.assertProductTitleInCart(Constants.SHIRT_TITLE);

        //assert the prices of the products
        productsPage.assertProductPriceInCart(Constants.BACKPACK_PRICE);
        productsPage.assertProductPriceInCart(Constants.SHIRT_PRICE);

    }


    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
        productsPage.checkoutWithValidInformation(Constants.USER_FIRST_NAME, Constants.USER_LAST_NAME, Constants.USER_ZIP_CODE);

        //expected titles and prices for assertions
        List<String> expectedTitles = List.of(Constants.BACKPACK_TITLE, Constants.SHIRT_TITLE);
        List<String> expectedPrices = List.of(Constants.BACKPACK_PRICE, Constants.SHIRT_PRICE);

        //assert items at checkout
        productsPage.assertItemsAtCheckout(expectedTitles, expectedPrices);

        //calculate expected total price with tax
        double expectedTotalWithTax = productsPage.calculateExpectedTotalWithTax();

        //assert total price with tax
        productsPage.assertTotalPriceWithTax(expectedTotalWithTax);
        productsPage.continueCheckout();
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        productsPage.addProductToCart(Constants.BACKPACK_TITLE);
        productsPage.addProductToCart(Constants.SHIRT_TITLE);
        productsPage.navigateToShoppingCart();
        productsPage.proceedToCheckout();
        productsPage.fillShippingDetails(Constants.USER_FIRST_NAME, Constants.USER_LAST_NAME, Constants.USER_ZIP_CODE);
        productsPage.continueCheckout();
        productsPage.finishCheckout();
        productsPage.navigateBackToProducts();
        productsPage.navigateToShoppingCart();

        //assert shopping cart is empty
        productsPage.assertShoppingCartIsEmpty();
    }

}
