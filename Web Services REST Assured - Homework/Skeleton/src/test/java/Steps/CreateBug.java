package Steps;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateBug {
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
                "        \"summary\": \"“Content on “About Us” page in the Russian version is empty\",\n" +
                "        \"description\": \"Preconditions:\\nBrowser: Google Chrome Version 114.0.5735.199 (Official Build) (64-bit)\\nURL: https://www.phptravels.net/ru ready to be pasted in the URL section\\n\\nSteps to reproduce:\\n1. Navigate to Chrome browser\\n2. Paste URL https://www.phptravels.net/ru\\n3. Press Enter to load the page\\n4. Navigate to \\\"Corporate\\\" section at the bottom of the page\\n5. Click on \\\"About Us\\\" button\\n\\nExpected result:\\nThe 'About Us' page displays content about the company or website\\n\\nActual result:\\n'About Us' page lacks visible content and the page appears to be empty\\n\\nPriority: High\\n\\nSeverity: Medium\",\n" +
                "        \"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
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
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("Content Type: " + response.getContentType());
    }
}
