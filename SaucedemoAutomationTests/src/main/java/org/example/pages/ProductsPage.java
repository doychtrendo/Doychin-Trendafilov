package org.example.pages;

import org.example.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String title) {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(String.format("//div[@class='inventory_item' and descendant::div[text()='%s']]", title))));
        WebElement addToCartButton = product.findElement(By.className("btn_inventory"));
        addToCartButton.click();
    }

    public void navigateToShoppingCart() {
        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    public void fillShippingDetails(String firstName, String lastName, String zip) {
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement postalCodeInput = driver.findElement(By.id("postal-code"));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(zip);
    }

    public void continueCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueButton.click();
    }

    public void finishCheckout() {
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
    }

    public void navigateBackToProducts() {
        WebElement backToProductsButton = driver.findElement(By.id("back-to-products"));
        backToProductsButton.click();
    }

    public int getNumberOfItemsInCart() {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        return items.size();
    }

    public List<String> getProductTitlesInCart() {
        List<WebElement> items = driver.findElements(By.className("inventory_item_name"));
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getProductPricesInCart() {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        return prices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void assertNumberOfItemsInCart(int expectedCount) {
        int actualCount = getNumberOfItemsInCart();
        Assertions.assertEquals(expectedCount, actualCount, "Incorrect number of items in the cart");
    }

    public void assertProductTitleInCart(String expectedTitle) {
        List<String> productTitles = getProductTitlesInCart();
        Assertions.assertTrue(productTitles.contains(expectedTitle), "Title not found in cart: " + expectedTitle);
    }

    public void assertProductPriceInCart(String expectedPrice) {
        List<String> productPrices = getProductPricesInCart();
        Assertions.assertTrue(productPrices.contains(expectedPrice), "Price not as expected: " + expectedPrice);
    }

    public void checkoutWithValidInformation(String firstName, String lastName, String zip) {
        proceedToCheckout();
        fillShippingDetails(firstName, lastName, zip);
        continueCheckout();
    }

    public void assertItemsAtCheckout(List<String> expectedTitles, List<String> expectedPrices) {
        //assert the number of items
        List<WebElement> itemsAtCheckout = driver.findElements(By.className("inventory_item_name"));
        Assertions.assertEquals(expectedTitles.size(), itemsAtCheckout.size(), "Items count not as expected at checkout");

        //assert that the correct items are displayed
        for (int i = 0; i < expectedTitles.size(); i++) {
            Assertions.assertEquals(expectedTitles.get(i), itemsAtCheckout.get(i).getText(),
                    "Item title not as expected at checkout: " + expectedTitles.get(i));
        }

        //assert the prices of the items
        List<WebElement> pricesAtCheckout = driver.findElements(By.className("inventory_item_price"));
        Assertions.assertEquals(expectedPrices.size(), pricesAtCheckout.size(), "Items price count not as expected at checkout");

        for (int i = 0; i < expectedPrices.size(); i++) {
            Assertions.assertEquals(expectedPrices.get(i), pricesAtCheckout.get(i).getText(),
                    "Item price not as expected at checkout: " + expectedPrices.get(i));
        }
    }

    public double calculateExpectedTotalWithTax() {
        double backpackPrice = Double.parseDouble(Constants.BACKPACK_PRICE.replace("$", ""));
        double shirtPrice = Double.parseDouble(Constants.SHIRT_PRICE.replace("$", ""));
        double subtotal = backpackPrice + shirtPrice;
        double tax = subtotal * 0.08;
        return subtotal + tax;
    }

    public void assertTotalPriceWithTax(double expectedTotalWithTax) {
        //assert the total price with tax
        WebElement totalElement = driver.findElement(By.className("summary_total_label"));
        double actualTotalWithTax = Double.parseDouble(totalElement.getText().replace("Total: $", ""));
        Assertions.assertEquals(expectedTotalWithTax, actualTotalWithTax,
                "Total price with tax not as expected at checkout");
    }
}
