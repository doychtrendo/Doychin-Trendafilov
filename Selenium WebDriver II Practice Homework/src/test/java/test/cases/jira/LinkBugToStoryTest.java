package test.cases.jira;

import org.junit.jupiter.api.Test;
import pages.jira.CreateProjectPage;
import pages.jira.LinkBugToStoryPage;

public class LinkBugToStoryTest extends BaseTest {

    @Test
    public void LinkBugAndStory() {
        login();
        CreateProjectPage createProjectPage = new CreateProjectPage(actions.getDriver());
        createProjectPage.navigateProject();

        LinkBugToStoryPage linkBugToStoryPage = new LinkBugToStoryPage(actions.getDriver());
        linkBugToStoryPage.linkBugToStory();
    }
}
