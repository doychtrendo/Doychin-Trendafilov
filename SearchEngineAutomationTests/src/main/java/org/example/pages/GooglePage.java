package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends BasePage {

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.com");
    }

    public void acceptConsent() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='L2AGLb']")));
        acceptButton.click();
    }

    public void search(String searchTerm) {
        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit' and @name='btnK'])[2]"));
        searchButton.click();
    }
}