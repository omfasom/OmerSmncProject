package Common;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
import static org.testng.Reporter.log;

import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

public class CustomFunctions {

  @Step("This method is to generate Bearer Token for Authentication")
  public static String generateBearerToken() {

    final String projectId = "078bd9dc-fb15-494c-a286-25cbcd718328";
    final String projectIdKey = "3nXudF5M.KCM4Nzx0w8PDDwhesN2OrdAP7KN8WJ0s4Re";

    final String token = getAuthToken(projectId, projectIdKey);
    log("Bearer token generated successfully");
    return token;
  }

  public static String getAuthToken(
      String projectId, String projectIdKey) {

    final String host = "https://"+projectId+":"+projectIdKey+"@api.up42.com/oauth/token";

    Response response =
        given()
            .contentType("application/x-www-form-urlencoded")
            .body("grant_type=client_credentials")
            .when()
            .post(host)
            .then()
            .and()
            .extract()
            .response();


    final String accessToken = response.path("access_token");
    final String tokenType =  response.path("token_type");

    assertNotNull(accessToken, "access_token cannot be null");
    assertNotNull(tokenType, "token_type cannot be null");

    return accessToken;
  }


}
