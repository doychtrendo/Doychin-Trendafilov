package Steps;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LinkStoryToBug {
    private final String baseUrl = Constants.BASE_URL;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = baseUrl;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        String username = Constants.USERNAME;
        authScheme.setUserName(username);
        String apiToken = Constants.API_TOKEN;
        authScheme.setPassword(apiToken);
        RestAssured.authentication = authScheme;
    }

    @Test
    public void testLinkStoryToBug() {
        String storyKey = Constants.STORY_KEY;
        String bugKey = Constants.BUG_KEY;
        linkStoryToBug(storyKey, bugKey);
    }

    private void linkStoryToBug(String storyKey, String bugKey) {
        String linkPayload = "{\n" +
                "    \"type\": {\n" +
                "        \"name\": \"Blocks\",\n" +
                "        \"inward\": \"is blocked by\",\n" +
                "        \"outward\": \"blocks\"\n" +
                "    },\n" +
                "    \"inwardIssue\": {\n" +
                "        \"key\": \"" + storyKey + "\"\n" +
                "    },\n" +
                "    \"outwardIssue\": {\n" +
                "        \"key\": \"" + bugKey + "\"\n" +
                "    }\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(linkPayload)
                .post(baseUrl + "/rest/api/2/issueLink");

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        response.then()
                .statusCode(201);
    }
}
