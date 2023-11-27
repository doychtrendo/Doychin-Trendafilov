package org.example.pages;

import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get(Constants.GOOGLE_URL);
    }

    public void acceptConsent() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.GOOGLE_ACCEPT_BUTTON_XPATH)));
        acceptButton.click();
    }

    public void search(String searchTerm) {
        WebElement searchField = driver.findElement(By.xpath(Constants.GOOGLE_SEARCH_FIELD_XPATH));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath(Constants.GOOGLE_SEARCH_BUTTON_XPATH));
        searchButton.click();
    }
}
