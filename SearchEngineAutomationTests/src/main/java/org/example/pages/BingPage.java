package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BingPage extends BasePage {

    public BingPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBing() {
        driver.get("https://www.bing.com");
    }

    public void acceptConsent() {
        WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='bnp_btn_accept']")));
        acceptButton.click();
    }

    public void search(String searchTerm) {
        WebElement searchField = driver.findElement(By.xpath("//*[@id='sb_form_q']"));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath("//label[@for='sb_form_go']"));
        searchButton.click();
    }
}