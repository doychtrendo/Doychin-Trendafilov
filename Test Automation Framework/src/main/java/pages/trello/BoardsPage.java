package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, "trello.boardsPage");
    }

    public void createBoard() {
        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.header.create.menuButton");
        actions.clickElement("trello.header.create.menuButton");

        actions.waitForElementClickable("trello.header.createBoard.dropDownButton");
        actions.clickElement("trello.header.createBoard.dropDownButton");

        actions.waitForElementClickable("trello.createBoard.titleInput");
        actions.typeValueInField(boardName, "trello.createBoard.titleInput");

        actions.waitForElementClickable("trello.create.board.submitButton");
        actions.clickElement("trello.create.board.submitButton");

    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName", boardName);
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }

    public void deleteBoard() {
        //find created board
        actions.waitForElementClickable("(//div[@class='board-tile-details is-badged'])[1]");

        //click
        actions.clickElement("(//div[@class='board-tile-details is-badged'])[1]");

        //hover the container
        actions.hoverOverElement("//*[@id='popover-boundary']/div/nav/div[1]/div/div/div[2]/div/div[3]/ul/div[2]/li[1]/a");
        actions.waitForElementClickable("//button[@type='button' and @aria-label='Board actions menu']");
        actions.clickElement("//button[@type='button' and @aria-label='Board actions menu']");

        //close board
        actions.waitForElementPresent("//button[@type='button' and @title='Close board']");
        actions.clickElement("//button[@type='button' and @title='Close board']");

        //confirm action
        actions.waitForElementPresent("//button[@type='button' and @title='Close']");
        actions.clickElement("//button[@type='button' and @title='Close']");

        //wait delete form to appear
        actions.waitForElementPresent("//h1[@data-testid='close-board-big-message']");

        //delete
        actions.clickElement("//button[@data-testid='close-board-delete-board-button']");

    }

    public void assertBoardIsDeleted() {
        actions.waitForElementNotPresent("trello.boardsPage.boardByTeamAndName", 10, "trello.boardPage.findBoard");
    }
}
