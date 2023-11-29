package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getConfigPropertyByKey;
import static com.telerikacademy.testframework.utils.Constants.*;

public class LoginPage extends BaseTrelloPage {

    public static String boardId = null;

    public LoginPage(WebDriver driver) {
        super(driver, TRELLO_LOGIN_PAGE);
    }

    public void loginUser(String userKey) {
        String username = getConfigPropertyByKey("trello.users." + userKey + ".username");
        String password = getConfigPropertyByKey("trello.users." + userKey + ".password");

        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible(TRELLO_LOGIN_PAGE_USERNAME);

        actions.typeValueInField(username, TRELLO_LOGIN_PAGE_USERNAME);
        actions.waitForElementVisible(TRELLO_LOGIN_PAGE_LOGIN_BUTTON);
        actions.clickElement(TRELLO_LOGIN_PAGE_LOGIN_BUTTON);

        actions.waitForElementClickable(TRELLO_LOGIN_PAGE_LOGIN_SUBMIT_BUTTON);
        actions.waitForElementClickable(TRELLO_LOGIN_PAGE_PASSWORD);

        actions.typeValueInField(password, TRELLO_LOGIN_PAGE_PASSWORD);
        actions.clickElement(TRELLO_LOGIN_PAGE_LOGIN_SUBMIT_BUTTON);

        actions.waitForElementVisible(TRELLO_HEADER_MEMBER_MENU_BUTTON);
    }
}
