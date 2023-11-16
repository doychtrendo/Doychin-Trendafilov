package org.example.pages;

import org.example.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String username, String pass) {
        WebElement usernameInput = driver.findElement(By.xpath(Constants.USERNAME_INPUT));
        WebElement passwordInput = driver.findElement(By.xpath(Constants.PASSWORD_INPUT));
        WebElement loginButton = driver.findElement(By.xpath(Constants.LOGIN_BUTTON));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(pass);
        loginButton.click();
    }

    public void logOut() {
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='logout_sidebar_link']")));
        logoutButton.click();
    }

}
