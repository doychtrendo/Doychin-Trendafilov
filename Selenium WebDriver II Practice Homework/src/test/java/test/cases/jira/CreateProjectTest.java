package test.cases.jira;

import org.junit.jupiter.api.Test;
import pages.jira.BaseJiraPage;
import pages.jira.CreateProjectPage;

public class CreateProjectTest extends BaseTest {

    @Test
    public void createNewProject() {
        login();
        CreateProjectPage newProject = new CreateProjectPage(actions.getDriver());
        newProject.createProject(BaseJiraPage.PROJECT_NAME);
    }
}

