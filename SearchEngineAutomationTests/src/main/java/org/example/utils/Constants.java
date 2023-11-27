package org.example.utils;

public class Constants {

    // Bing Page locators
    public static final String BING_SEARCH_FIELD_XPATH = "//*[@id='sb_form_q']";
    public static final String BING_SEARCH_BUTTON_XPATH = "//label[@for='sb_form_go']";
    public static final String BING_ACCEPT_BUTTON_XPATH = "//button[@id='bnp_btn_accept']";

    // Google Page locators
    public static final String GOOGLE_SEARCH_FIELD_XPATH = "//textarea[@type='search']";
    public static final String GOOGLE_SEARCH_BUTTON_XPATH = "(//input[@type='submit' and @name='btnK'])[2]";
    public static final String GOOGLE_ACCEPT_BUTTON_XPATH = "//button[@id='L2AGLb']";
}
