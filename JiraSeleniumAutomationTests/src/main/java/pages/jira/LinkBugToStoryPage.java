package pages.jira;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LinkBugToStoryPage extends BaseJiraPage {

    public LinkBugToStoryPage(WebDriver driver) {
        super(driver, "jira.homePage");

    }

    public void linkBugToStory() {
        actions.waitForElementVisible("jira.issuesList.button");
        actions.clickElement("jira.issuesList.button");

        actions.waitForElementVisible("jira.allIssues.list");
        actions.clickElement("jira.allIssues.list");

        actions.waitForElementVisible("jira.allIssues.search");
        actions.clickElement("jira.allIssues.search");
        actions.typeValueInField(BUG_KEY, "jira.allIssues.search");

        actions.waitForElementVisible("jira.linkIssue.button");
        actions.clickElement("jira.linkIssue.button");

        actions.waitForElementClickable("jira.linkIssue.options");
        actions.clickElement("jira.linkIssue.options");

        actions.waitForElementClickable("jira.linkIssueBlock.option");
        actions.clickElement("jira.linkIssueBlock.option");

        actions.waitForElementVisible("jira.searchIssues.field");
        actions.typeValueInField(STORY_KEY, "jira.searchIssues.field");

        actions.waitForElementVisible("jira.searchIssues.field");
        actions.typeValueInField(String.valueOf(Keys.ENTER), "jira.searchIssues.field");

        actions.waitForElementVisible("jira.link.button");
        actions.clickElement("jira.link.button");
    }
}
