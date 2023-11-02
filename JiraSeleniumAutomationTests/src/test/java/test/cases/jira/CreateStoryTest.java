package test.cases.jira;

import org.junit.jupiter.api.Test;
import pages.jira.BaseJiraPage;
import pages.jira.CreateProjectPage;
import pages.jira.CreateStoryPage;

public class CreateStoryTest extends BaseTest {

    @Test
    public void createStory() {
        login();
        CreateProjectPage createProjectPage = new CreateProjectPage(actions.getDriver());
        createProjectPage.navigateProject();

        CreateStoryPage createStoryPage = new CreateStoryPage(actions.getDriver());
        createStoryPage.createStory(BaseJiraPage.USER_STORY_NAME, BaseJiraPage.USER_STORY);
    }
}
