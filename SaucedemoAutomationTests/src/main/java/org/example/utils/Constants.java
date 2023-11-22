package org.example.utils;

public class Constants {

    //login page locators
    public static final String USERNAME_INPUT = "//input[@data-test='username']";
    public static final String PASSWORD_INPUT = "//input[@data-test='password']";
    public static final String LOGIN_BUTTON = "//input[@data-test='login-button']";
    public static final String BURGER_MENU = "#react-burger-menu-btn";
    public static final String LOGOUT_BUTTON = "//*[@id='logout_sidebar_link']";

    //user data
    public static final String USER_FIRST_NAME = "Jack";
    public static final String USER_LAST_NAME = "Pott";
    public static final String USER_ZIP_CODE = "8888";

    //general constants
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String STANDARD_USER_USERNAME = "standard_user";
    public static final String STANDARD_USER_PASSWORD = "secret_sauce";
    public static final String EXPECTED_URL_AFTER_LOGIN = "https://www.saucedemo.com/inventory.html";
    public static final String URL_NOT_AS_EXPECTED_MESSAGE = "URL not as expected after login";

    //product titles
    public static final String BACKPACK_TITLE = "Sauce Labs Backpack";
    public static final String SHIRT_TITLE = "Sauce Labs Bolt T-Shirt";

    //product prices
    public static final String BACKPACK_PRICE = "$29.99";
    public static final String SHIRT_PRICE = "$15.99";

    //ProductsPage locators
    public static final String PRODUCT_TITLE_XPATH = "//div[@class='inventory_item' and descendant::div[text()='%s']]";
    public static final String ADD_TO_CART_BUTTON_CLASS = "btn_inventory";
    public static final String SHOPPING_CART_LINK_CLASS = "shopping_cart_link";
    public static final String CHECKOUT_BUTTON_ID = "checkout";
    public static final String FIRST_NAME_INPUT_ID = "first-name";
    public static final String LAST_NAME_INPUT_ID = "last-name";
    public static final String POSTAL_CODE_INPUT_ID = "postal-code";
    public static final String CONTINUE_BUTTON_ID = "continue";
    public static final String FINISH_BUTTON_ID = "finish";
    public static final String BACK_TO_PRODUCTS_BUTTON_ID = "back-to-products";
    public static final String ITEM_NAME_CLASS = "inventory_item_name";
    public static final String ITEM_PRICE_CLASS = "inventory_item_price";
    public static final String SUMMARY_TOTAL_LABEL_CLASS = "summary_total_label";

    //error messages
    public static final String INCORRECT_ITEMS_COUNT_ERROR = "Incorrect number of items in the cart";
    public static final String TITLE_NOT_FOUND_IN_CART_ERROR = "Title not found in cart: ";
    public static final String PRICE_NOT_AS_EXPECTED_ERROR = "Price not as expected: ";
    public static final String ITEMS_COUNT_NOT_AS_EXPECTED_ERROR = "Items count not as expected at checkout";
    public static final String ITEM_TITLE_NOT_AS_EXPECTED_ERROR = "Item title not as expected at checkout: ";
    public static final String ITEM_PRICE_NOT_AS_EXPECTED_ERROR = "Item price not as expected at checkout: ";
    public static final String TOTAL_PRICE_WITH_TAX_NOT_AS_EXPECTED_ERROR = "Total price with tax not as expected at checkout";
    public static final String SHOPPING_CART_NOT_EMPTY_ERROR = "Items count not as expected";

}
