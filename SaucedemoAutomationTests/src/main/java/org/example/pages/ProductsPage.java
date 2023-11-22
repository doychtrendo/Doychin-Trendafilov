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
                By.xpath(String.format(Constants.PRODUCT_TITLE_XPATH, title))));
        WebElement addToCartButton = product.findElement(By.className(Constants.ADD_TO_CART_BUTTON_CLASS));
        addToCartButton.click();
    }

    public void navigateToShoppingCart() {
        WebElement cartLink = driver.findElement(By.className(Constants.SHOPPING_CART_LINK_CLASS));
        cartLink.click();
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id(Constants.CHECKOUT_BUTTON_ID));
        checkoutButton.click();
    }

    public void fillShippingDetails(String firstName, String lastName, String zip) {
        WebElement firstNameInput = driver.findElement(By.id(Constants.FIRST_NAME_INPUT_ID));
        WebElement lastNameInput = driver.findElement(By.id(Constants.LAST_NAME_INPUT_ID));
        WebElement postalCodeInput = driver.findElement(By.id(Constants.POSTAL_CODE_INPUT_ID));

        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(zip);
    }

    public void continueCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(Constants.CONTINUE_BUTTON_ID)));
        continueButton.click();
    }

    public void finishCheckout() {
        WebElement finishButton = driver.findElement(By.id(Constants.FINISH_BUTTON_ID));
        finishButton.click();
    }

    public void navigateBackToProducts() {
        WebElement backToProductsButton = driver.findElement(By.id(Constants.BACK_TO_PRODUCTS_BUTTON_ID));
        backToProductsButton.click();
    }

    public int getNumberOfItemsInCart() {
        List<WebElement> items = driver.findElements(By.className(Constants.ITEM_NAME_CLASS));
        return items.size();
    }

    public List<String> getProductTitlesInCart() {
        List<WebElement> items = driver.findElements(By.className(Constants.ITEM_NAME_CLASS));
        return items.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getProductPricesInCart() {
        List<WebElement> prices = driver.findElements(By.className(Constants.ITEM_PRICE_CLASS));
        return prices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void assertNumberOfItemsInCart(int expectedCount) {
        int actualCount = getNumberOfItemsInCart();
        Assertions.assertEquals(expectedCount, actualCount, Constants.INCORRECT_ITEMS_COUNT_ERROR);
    }

    public void assertProductTitleInCart(String expectedTitle) {
        List<String> productTitles = getProductTitlesInCart();
        Assertions.assertTrue(productTitles.contains(expectedTitle), Constants.TITLE_NOT_FOUND_IN_CART_ERROR +
                expectedTitle);
    }

    public void assertProductPriceInCart(String expectedPrice) {
        List<String> productPrices = getProductPricesInCart();
        Assertions.assertTrue(productPrices.contains(expectedPrice), Constants.PRICE_NOT_AS_EXPECTED_ERROR +
                expectedPrice);
    }

    public void checkoutWithValidInformation(String firstName, String lastName, String zip) {
        proceedToCheckout();
        fillShippingDetails(firstName, lastName, zip);
        continueCheckout();
    }

    public void assertItemsAtCheckout(List<String> expectedTitles, List<String> expectedPrices) {
        //assert the number of items
        List<WebElement> itemsAtCheckout = driver.findElements(By.className(Constants.ITEM_NAME_CLASS));
        Assertions.assertEquals(expectedTitles.size(), itemsAtCheckout.size(), Constants.ITEMS_COUNT_NOT_AS_EXPECTED_ERROR);

        //assert that the correct items are displayed
        for (int i = 0; i < expectedTitles.size(); i++) {
            Assertions.assertEquals(expectedTitles.get(i), itemsAtCheckout.get(i).getText(),
                    Constants.ITEM_TITLE_NOT_AS_EXPECTED_ERROR + expectedTitles.get(i));
        }

        //assert the prices of the items
        List<WebElement> pricesAtCheckout = driver.findElements(By.className(Constants.ITEM_PRICE_CLASS));
        Assertions.assertEquals(expectedPrices.size(), pricesAtCheckout.size(), Constants.ITEM_PRICE_NOT_AS_EXPECTED_ERROR);

        for (int i = 0; i < expectedPrices.size(); i++) {
            Assertions.assertEquals(expectedPrices.get(i), pricesAtCheckout.get(i).getText(),
                    Constants.ITEM_PRICE_NOT_AS_EXPECTED_ERROR + expectedPrices.get(i));
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
        WebElement totalElement = driver.findElement(By.className(Constants.SUMMARY_TOTAL_LABEL_CLASS));
        double actualTotalWithTax = Double.parseDouble(totalElement.getText().replace("Total: $", ""));
        Assertions.assertEquals(expectedTotalWithTax, actualTotalWithTax,
                Constants.TOTAL_PRICE_WITH_TAX_NOT_AS_EXPECTED_ERROR);
    }

    public void assertShoppingCartIsEmpty() {
        var items = driver.findElements(By.className(Constants.ITEM_NAME_CLASS));
        Assertions.assertEquals(0, items.size(), Constants.SHOPPING_CART_NOT_EMPTY_ERROR);
    }
}
