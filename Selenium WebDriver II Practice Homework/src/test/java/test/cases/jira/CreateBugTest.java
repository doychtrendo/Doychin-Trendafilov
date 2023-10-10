package test.cases.jira;

import org.junit.jupiter.api.Test;
import pages.jira.BaseJiraPage;
import pages.jira.CreateBugPage;
import pages.jira.CreateProjectPage;

public class CreateBugTest extends BaseTest {

    @Test
    public void createBug() {
        login();
        CreateProjectPage createProjectPage = new CreateProjectPage(actions.getDriver());
        createProjectPage.navigateProject();

        CreateBugPage createBugPage = new CreateBugPage(actions.getDriver());
        createBugPage.createBug(BaseJiraPage.BUG_NAME, BaseJiraPage.BUG_DESCRIPTION);
    }
}
