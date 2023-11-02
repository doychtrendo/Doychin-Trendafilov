package pages.jira;

import org.openqa.selenium.WebDriver;

public class CreateBugPage extends BaseJiraPage {
    public CreateBugPage(WebDriver driver) {
        super(driver, "jira.homePage");
    }

    public void createBug(String bugName, String bugDescription) {
        actions.waitForElementClickable("jira.createIssue.button");
        actions.clickElement("jira.createIssue.button");

        actions.waitForElementClickable("jira.issueTypeMenu.options");
        actions.clickElement("jira.issueTypeMenu.options");

        actions.clickElementWithJavaScriptExecutor("jira.bugDropDown.option");

        actions.waitForElementClickable("jira.titleText.field");
        actions.typeValueInField(bugName, "jira.titleText.field");

        actions.waitForElementVisible("jira.description.field");
        actions.typeValueInField(bugDescription, "jira.description.field");

        actions.waitForElementClickable("jira.selectPriority.options");
        actions.clickElement("jira.selectPriority.options");

        actions.waitForElementClickable("jira.high.priority");
        actions.clickElement("jira.high.priority");

        actions.waitForElementClickable("jira.create.button");
        actions.clickElement("jira.create.button");
    }

}
