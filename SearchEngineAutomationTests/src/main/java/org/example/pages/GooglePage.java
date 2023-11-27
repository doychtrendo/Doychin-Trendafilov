package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.utils.Constants.*;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get(GOOGLE_URL);
    }

    public void acceptConsent() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(GOOGLE_ACCEPT_BUTTON_XPATH)));
        acceptButton.click();
    }

    public void search(String searchTerm) {
        WebElement searchField = driver.findElement(By.xpath(GOOGLE_SEARCH_FIELD_XPATH));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath(GOOGLE_SEARCH_BUTTON_XPATH));
        searchButton.click();
    }
}
