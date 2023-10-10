package pages.jira;

import org.openqa.selenium.WebDriver;

public class CreateStoryPage extends BaseJiraPage {

    public CreateStoryPage(WebDriver driver) {
        super(driver, "jira.homePage");
    }

    public void createStory(String storyName, String storyDescription) {
        actions.waitForElementClickable("jira.createIssue.button");
        actions.clickElement("jira.createIssue.button");

        actions.waitForElementClickable("jira.issueTypeMenu.options");
        actions.clickElement("jira.issueTypeMenu.options");

        actions.clickElementWithJavaScriptExecutor("jira.storyDropDown.option");

        actions.waitForElementVisible("jira.titleText.field");
        actions.typeValueInField(storyName, "jira.titleText.field");

        actions.waitForElementVisible("jira.description.field");
        actions.typeValueInField(storyDescription, "jira.description.field");

        actions.waitForElementClickable("jira.selectPriority.options");
        actions.clickElement("jira.selectPriority.options");

        actions.waitForElementClickable("jira.high.priority");
        actions.clickElement("jira.high.priority");

        actions.waitForElementClickable("jira.create.button");
        actions.clickElement("jira.create.button");
    }

}
