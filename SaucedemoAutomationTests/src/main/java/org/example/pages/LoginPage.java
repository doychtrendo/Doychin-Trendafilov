package org.example.pages;

import org.example.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String pass) {
        WebElement usernameInput = driver.findElement(By.xpath(Constants.USERNAME_INPUT));
        WebElement passwordInput = driver.findElement(By.xpath(Constants.PASSWORD_INPUT));
        WebElement loginButton = driver.findElement(By.xpath(Constants.LOGIN_BUTTON));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginButton.click();
    }

    public void logout() {
        WebElement burgerMenu = driver.findElement(By.cssSelector(Constants.BURGER_MENU));
        burgerMenu.click();

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Constants.LOGOUT_BUTTON)));
        logoutButton.click();
    }

    public void assertUserIsAuthenticated() {
        Assertions.assertEquals(Constants.EXPECTED_URL_AFTER_LOGIN, driver.getCurrentUrl(), Constants.URL_NOT_AS_EXPECTED_MESSAGE);
    }

}
