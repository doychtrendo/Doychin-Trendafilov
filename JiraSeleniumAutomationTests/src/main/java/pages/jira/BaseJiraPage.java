package pages.jira;

import com.jira.testframework.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BaseJiraPage extends BasePage {
    public static final String PROJECT_NAME = "WebDriver Homework";
    public static final String USER_STORY = "User Story:\n" +
            "As a new user, I need to access the 'About Us' page to gain more information about the company's background.";
    public static final String USER_STORY_NAME = "User navigating to the 'About Us' Page";
    public static final String PROJECT_KEY = "WD";
    public static final String BUG_KEY = "WD-1";
    public static final String STORY_KEY = "WD-2";
    public static final String BUG_NAME = "“Content on “About Us” page in the Russian version is empty";
    public static final String BUG_DESCRIPTION = "Description:\n" +
            "When accessing the website URL https://www.phptravels.net/ru , the 'About Us' page appears to be empty, with no visible content\n\n" +
            "Preconditions:\n" +
            "Browser: Google Chrome Version 114.0.5735.199 (Official Build) (64-bit)\n" +
            "URL: https://www.phptravels.net/ru ready to be pasted in the URL section\n\n" +
            "Steps to reproduce:\n" +
            "1. Navigate to Chrome browser\n" +
            "2. Paste URL https://www.phptravels.net/ru\n" +
            "3. Press Enter to load the page\n" +
            "4. Navigate to “Corporate” section at the bottom of the page\n" +
            "5. Click on “About Us” button\n\n" +
            "Expected result:\n" +
            "The 'About Us' page displays content about the company or website\n\n" +
            "Actual result:\n" +
            "'About Us' page lacks visible content and the page appears to be empty\n";

    public BaseJiraPage(WebDriver driver, String pageUrlKey) {
        super(driver, pageUrlKey);
    }
}
