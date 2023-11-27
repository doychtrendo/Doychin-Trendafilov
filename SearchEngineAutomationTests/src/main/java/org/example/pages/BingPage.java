package org.example.pages;

import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BingPage extends BasePage {

    public BingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBing() {
        driver.get(Constants.BING_URL);
    }

    public void acceptConsent() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.BING_ACCEPT_BUTTON_XPATH)));
        acceptButton.click();
    }

    public void search(String searchTerm) {
        WebElement searchField = driver.findElement(By.xpath(Constants.BING_SEARCH_FIELD_XPATH));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath(Constants.BING_SEARCH_BUTTON_XPATH));
        searchButton.click();
    }
}
