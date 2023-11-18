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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsTests extends BaseTest {

    private ProductsPage productsPage;
    private LoginPage loginPage;

    @BeforeEach
    public void setup() {
        driver = startBrowser(BrowserTypes.CHROME);
        loginPage = new LoginPage(driver);
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

        //assert the number of items
        List<WebElement> itemsAtCheckout = driver.findElements(By.className("inventory_item_name"));
        Assertions.assertEquals(2, itemsAtCheckout.size(), "Items count not as expected at checkout");

        //assert that the correct items are displayed
        Assertions.assertEquals(Constants.BACKPACK_TITLE, itemsAtCheckout.get(0).getText(), "Backpack title not as expected at checkout");
        Assertions.assertEquals(Constants.SHIRT_TITLE, itemsAtCheckout.get(1).getText(), "Shirt title not as expected at checkout");

        //assert the prices of the items
        List<WebElement> pricesAtCheckout = driver.findElements(By.className("inventory_item_price"));
        Assertions.assertEquals(2, pricesAtCheckout.size(), "Items price count not as expected at checkout");
        Assertions.assertEquals(Constants.BACKPACK_PRICE, pricesAtCheckout.get(0).getText(), "Backpack price not as expected at checkout");
        Assertions.assertEquals(Constants.SHIRT_PRICE, pricesAtCheckout.get(1).getText(), "Shirt price not as expected at checkout");

        //assert the total price
        double backpackPrice = Double.parseDouble(Constants.BACKPACK_PRICE.replace("$", ""));
        double shirtPrice = Double.parseDouble(Constants.SHIRT_PRICE.replace("$", ""));
        double subtotal = backpackPrice + shirtPrice;
        double tax = subtotal * 0.08;
        double totalWithTax = subtotal + tax;
        String expectedTotal = String.format("Total: $%.2f", totalWithTax);
        WebElement totalElement = driver.findElement(By.className("summary_total_label"));
        Assertions.assertEquals(expectedTotal, totalElement.getText(), "Total price with tax not as expected at checkout");
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
