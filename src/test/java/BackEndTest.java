import static Backend.java.CustomFunctions.generateBearerToken;

import Backend.java.Request;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class BackEndTest {

  @Test
  @Description("Verify Unlock the Barn")
  public void testBarnUnlock() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.barnUnlock(bearerToken);
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode,200,"Unlock the Barn is successful!");
  }

  @Test
  @Description("Verify Unlock the Barn success response")
  public void testBarnUnlockResponseVerification() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.barnUnlock(bearerToken);
    String responseString = response.asString();
    Assert.assertTrue(responseString.contains("true"),"Success response is Correct!");
  }

  @Test
  @Description("Verify Put the Toilet Seat Down")
  public void testToiletSeatDown() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.toiletSeatDown(bearerToken);
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode,200,"Put the Toilet Seat Down is successful!");
  }

  @Test
  @Description("Verify Put the Toilet Seat Down success response")
  public void testToiletSeatDownResponseVerification() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.toiletSeatDown(bearerToken);
    String responseString = response.asString();
    Assert.assertTrue(responseString.contains("true"),"Success response is Correct!");
  }

  @Test
  @Description("Verify Feed Your Chickens")
  public void testChickensFeed() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.chickensFeed(bearerToken);
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode,200,"Feed Your Chickens is successful!");
  }

  @Test
  @Description("Verify Feed Your Chickens success response")
  public void testChickensFeedResponseVerification() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.chickensFeed(bearerToken);
    String responseString = response.asString();
    Assert.assertTrue(responseString.contains("true"),"Success response is Correct!");
  }

  @Test
  @Description("Verify Collect Eggs from Your Chickens")
  public void testEggsCollect() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.eggsCollect(bearerToken);
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode,200,"Collect Eggs from Your Chickens is successful!");
  }

  @Test
  @Description("Verify Collect Eggs from Your Chickens success response")
  public void testEggsCollectResponseVerification() {
    final String bearerToken = generateBearerToken();

    Response response =
        Request.eggsCollect(bearerToken);
    String responseString = response.asString();
    Assert.assertTrue(responseString.contains("true"),"Success response is Correct!");
  }

}
