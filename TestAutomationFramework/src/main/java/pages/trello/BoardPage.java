package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.utils.Constants.*;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {
        // Find created board
        actions.waitForElementClickable(TRELLO_BOARD_PAGE_CREATED_BOARD);
        actions.clickElement(TRELLO_BOARD_PAGE_CREATED_BOARD);

        // Find "Add Card" button and click
        actions.waitForElementClickable(TRELLO_BOARD_PAGE_ADD_CARD_BUTTON);
        actions.clickElement(TRELLO_BOARD_PAGE_ADD_CARD_BUTTON);

        // Card name
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_CARD_COMPOSER_TEXTAREA);
        actions.typeValueInField(cardName, TRELLO_BOARD_PAGE_CARD_COMPOSER_TEXTAREA);

        // Click "Submit"
        actions.clickElement(TRELLO_BOARD_PAGE_SUBMIT_BUTTON);

        // Assert card is created
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_CREATED_CARD);
    }

    public void moveCardToList(String cardName, String listName) {
        // Find created board
        actions.waitForElementClickable(TRELLO_BOARD_PAGE_CREATED_BOARD);
        actions.clickElement(TRELLO_BOARD_PAGE_CREATED_BOARD);

        // Wait for the created card
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_CREATED_CARD);

        // Drag source and drop
        actions.selectOptionsFromDragAndDrop(TRELLO_BOARD_PAGE_CREATED_CARD, TRELLO_BOARD_PAGE_SECOND_LIST);
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_LIST_BY_NAME, listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_LIST_WRAPPER);
    }

    public void assertCardExists() {
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_CREATED_CARD);
    }

    public void assertCardIsMoved() {
        actions.waitForElementPresent(TRELLO_BOARD_PAGE_CREATED_CARD);
    }
}
