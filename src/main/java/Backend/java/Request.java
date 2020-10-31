package Backend.java;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

public class Request {

    @Step("Unlock the Barn POST request")
    public static Response barnUnlock(String bearerToken)
        {
    final String resourcePath = Resource.resource;



     io.restassured.response.Response response =
          given()
              .baseUri(resourcePath)
              .auth()
              .oauth2(bearerToken)
              .contentType(ContentType.JSON)
              .and()
              .when()
              .post("/barn-unlock")
              .then()
              .log()
              .body()
              .and()
              .extract()
              .response();
      return response;
    }

  @Step("Put the Toilet Seat Down")
  public static Response toiletSeatDown(String bearerToken)
  {
    final String resourcePath = Resource.resource;



    io.restassured.response.Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .and()
            .when()
            .post("/toiletseat-down")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Feed Your Chickens")
  public static Response chickensFeed(String bearerToken)
  {
    final String resourcePath = Resource.resource;



    io.restassured.response.Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .and()
            .when()
            .post("/chickens-feed")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Collect Eggs from Your Chickens")
  public static Response eggsCollect(String bearerToken)
  {
    final String resourcePath = Resource.resource;



    io.restassured.response.Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .and()
            .when()
            .post("/eggs-collect")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

}

