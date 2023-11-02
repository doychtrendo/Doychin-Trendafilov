package pages.jira;

import org.openqa.selenium.WebDriver;

public class CreateProjectPage extends BaseJiraPage {

    public CreateProjectPage(WebDriver driver) {
        super(driver, "jira.homePage");
    }

    public void createProject(String projectName) {
        actions.waitForElementVisible("jira.jiraSoftware.button");
        actions.clickElement("jira.jiraSoftware.button");

        actions.waitForElementVisible("jira.createProject.button");
        actions.clickElement("jira.createProject.button");

        actions.waitForElementVisible("jira.createScrumProject.button");
        actions.clickElement("jira.createScrumProject.button");

        actions.waitForElementVisible("jira.useTemplate.button");
        actions.clickElement("jira.useTemplate.button");

        actions.waitForElementVisible("jira.companyManagedProject.button");
        actions.clickElement("jira.companyManagedProject.button");

        actions.waitForElementVisible("jira.projectName");
        actions.typeValueInField(projectName, "jira.projectName");

        actions.waitForElementVisible("jira.projectKey");
        actions.typeValueInField(PROJECT_KEY, "jira.projectKey");

        actions.clickElement("jira.next.button");
    }

    public void navigateProject() {
        actions.waitForElementVisible("jira.jiraSoftware.button");
        actions.clickElement("jira.jiraSoftware.button");

        actions.waitForElementVisible("jira.projectsList.button");
        actions.clickElement("jira.projectsList.button");

        actions.waitForElementVisible("jira.viewAllProjects.button");
        actions.clickElement("jira.viewAllProjects.button");

        actions.waitForElementVisible("jira.projectsSearch.field");
        actions.typeValueInField(PROJECT_NAME, "jira.projectsSearch.field");

        actions.waitForElementVisible("//span[text()='WebDriver Homework']");
        actions.clickElement("//span[text()='WebDriver Homework']");
    }

}
