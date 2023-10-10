package pages.trello;

import org.openqa.selenium.WebDriver;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addCardToList(String cardName) {
        //find created board
        actions.waitForElementClickable("(//div[@class='board-tile-details is-badged'])[1]");
        actions.clickElement("(//div[@class='board-tile-details is-badged'])[1]");


        //find "Add Card" button and click
        actions.waitForElementClickable("(//a[@data-testid='list-add-card-button'])[1]");
        actions.clickElement("(//a[@data-testid='list-add-card-button'])[1]");

        //card name
        actions.waitForElementPresent("//textarea[@data-testid='list-card-composer-textarea']");
        actions.typeValueInField(cardName, "//textarea[@data-testid='list-card-composer-textarea']");

        //click "Submit"
        actions.clickElement("(//input[@type='submit'])[1]");

        //asser card is created
        actions.waitForElementPresent("//a[@data-testid='trello-card']");
    }

    public void moveCardToList(String cardName, String listName) {
        //find created board
        actions.waitForElementClickable("(//div[@class='board-tile-details is-badged'])[1]");
        actions.clickElement("(//div[@class='board-tile-details is-badged'])[1]");

        //wait for the created card
        actions.waitForElementPresent("//a[@data-testid='trello-card']");

        //drag source and drop
        actions.selectOptionsFromDragAndDrop("//a[@data-testid='trello-card']", "(//div[@class='list js-list-content'])[2]");
    }


    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }

    public void assertCardExists() {
        actions.waitForElementPresent("//a[@data-testid='trello-card']");
    }

    public void assertCardIsMoved() {
        actions.waitForElementPresent("//a[@data-testid='trello-card']");
    }

}

