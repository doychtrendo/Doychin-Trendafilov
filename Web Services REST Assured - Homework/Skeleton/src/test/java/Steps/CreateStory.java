package Steps;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateStory {
    private Response response;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Constants.BASE_URL;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        String username = Constants.USERNAME;
        authScheme.setUserName(username);
        String apiToken = Constants.API_TOKEN;
        authScheme.setPassword(apiToken);
        RestAssured.authentication = authScheme;

        String payload = "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"WSPHA\"\n" +
                "        },\n" +
                "        \"summary\": \"User navigating to the 'About Us' Page\",\n" +
                "        \"description\": \"User Story:\\nAs a new user, I need to access the 'About Us' page to gain more information about the company's background.\\n Priority: High\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Story\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String apiPath = Constants.API_PATH;
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(apiPath);

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
    }

    @Test
    public void correctStatusReturned() {
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test
    public void contentTypeHeaderIsPresent() {
        Assert.assertNotNull(response.getHeader("Content-Type"));
    }

    @Test
    public void responseHasApplicationJsonContentType() {
        Assert.assertTrue(response.getContentType().contains("application/json"));
    }

    @Test
    public void responseBodyIsValidJson() {
        Assert.assertNotNull(response.getBody().jsonPath().get(""));
    }

    @Test
    public void responseContainsRequiredAttributes() {
        Assert.assertNotNull(response.getBody().jsonPath().get("id"));
        Assert.assertNotNull(response.getBody().jsonPath().get("key"));
        Assert.assertNotNull(response.getBody().jsonPath().get("self"));
    }

    @Test
    public void responseTimeIsLessThan2000ms() {
        Assert.assertTrue(response.getTime() < 2000L);
    }

    @Test
    public void print() {
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("Content Type: " + response.getContentType());
    }
}
