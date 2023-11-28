package org.example.utils;

public class Constants {

    public static final String GOOGLE_URL = "https://www.google.com";
    public static final String BING_URL = "https://www.bing.com";


    public static final String BING_SEARCH_FIELD_XPATH = "//*[@id='sb_form_q']";
    public static final String BING_SEARCH_BUTTON_XPATH = "//label[@for='sb_form_go']";
    public static final String BING_ACCEPT_BUTTON_XPATH = "//button[@id='bnp_btn_accept']";
    public static final String BING_FIRST_RESULT_XPATH = "//h2[@class=' b_topTitle']";


    public static final String GOOGLE_SEARCH_FIELD_XPATH = "//textarea[@type='search']";
    public static final String GOOGLE_SEARCH_BUTTON_XPATH = "(//input[@type='submit' and @name='btnK'])[2]";
    public static final String GOOGLE_ACCEPT_BUTTON_XPATH = "//button[@id='L2AGLb']";

    public static final String GOOGLE_FIRST_RESULT_XPATH = "(//a/h3)[1]";


    public static final String SEARCH_TERM = "Telerik Academy Alpha";
    public static final String EXPECTED_TITLE = "IT Career Start in 6 Months - Telerik Academy Alpha";


    public static final String TITLE_NOT_MATCH_ERROR = "Search result title does not match. Expected: %s, Actual: %s";
}
