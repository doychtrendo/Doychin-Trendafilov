package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.utils.Constants.*;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, TRELLO_BOARDS_PAGE);
    }

    public void createBoard() {
        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_MENU_BUTTON);
        actions.clickElement(TRELLO_BOARDS_PAGE_MENU_BUTTON);

        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_CREATE_BOARD_DROPDOWN);
        actions.clickElement(TRELLO_BOARDS_PAGE_CREATE_BOARD_DROPDOWN);

        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_TITLE_INPUT);
        actions.typeValueInField(TRELLO_BOARD_NAME, TRELLO_BOARDS_PAGE_TITLE_INPUT);

        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_CREATE_BUTTON);
        actions.clickElement(TRELLO_BOARDS_PAGE_CREATE_BUTTON);
    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible(TRELLO_BOARDS_PAGE_BOARD_BY_NAME, boardName);
        actions.clickElement(TRELLO_BOARDS_PAGE_BOARD_BY_NAME, boardName);
    }

    public void deleteBoard() {
        //find created board
        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_DELETE_BOARD_BUTTON);
        actions.clickElement(TRELLO_BOARDS_PAGE_DELETE_BOARD_BUTTON);

        //click
        actions.clickElement(TRELLO_BOARDS_PAGE_DELETE_BOARD_BUTTON);

        //hover the container
        actions.hoverOverElement(TRELLO_BOARDS_PAGE_BOARD_ACTIONS_MENU);
        actions.waitForElementClickable(TRELLO_BOARDS_PAGE_BOARD_ACTIONS_MENU);
        actions.clickElement(TRELLO_BOARDS_PAGE_BOARD_ACTIONS_MENU);

        //close board
        actions.waitForElementPresent(TRELLO_BOARDS_PAGE_CLOSE_BOARD_BUTTON);
        actions.clickElement(TRELLO_BOARDS_PAGE_CLOSE_BOARD_BUTTON);

        //confirm action
        actions.waitForElementPresent(TRELLO_BOARDS_PAGE_CONFIRM_CLOSE_BUTTON);
        actions.clickElement(TRELLO_BOARDS_PAGE_CONFIRM_CLOSE_BUTTON);

        //wait delete form to appear
        actions.waitForElementPresent(TRELLO_BOARDS_PAGE_CLOSE_BOARD_BIG_MESSAGE);

        //delete
        actions.clickElement(TRELLO_BOARDS_PAGE_DELETE_CONFIRM_BUTTON);
    }

    public void assertBoardIsDeleted() {
        actions.waitForElementNotPresent(TRELLO_BOARDS_PAGE_BOARD_BY_NAME, 10, "trello.boardPage.findBoard");
    }
}
