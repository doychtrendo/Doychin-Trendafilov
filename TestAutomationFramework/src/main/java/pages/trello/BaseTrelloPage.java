package pages.trello;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public abstract class BaseTrelloPage extends BasePage {

    public BaseTrelloPage(WebDriver driver, String pageUrlKey) {
        super(driver, pageUrlKey);
    }
}
