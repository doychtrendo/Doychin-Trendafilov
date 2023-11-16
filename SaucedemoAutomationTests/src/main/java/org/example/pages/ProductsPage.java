package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
        WebElement continueButton = driver.findElement(By.id("continue"));
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

}
