package Backend.java;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;
import static org.testng.Reporter.log;

import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

public class CustomFunctions {

  @Step("This method is to generate Bearer Token for Authentication")
  public static String generateBearerToken() {

    final String clientId = "OmrSmncProject";
    final String clientSecret = "375a01f38e158ecdd5843faacb302276";

    final String token = getAuthTokenWithClientIdAndSecret(clientId, clientSecret);
    log("Bearer token generated successfully");
    return token;
  }

  public static String getAuthTokenWithClientIdAndSecret(
      String clientId, String clientSecret) {

    final String host = "http://coop.apps.symfonycasts.com/token";

    Response response =
        given()
            .auth()
            .preemptive()
            .basic(clientId, clientSecret)
            .formParam("grant_type", "client_credentials")
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
