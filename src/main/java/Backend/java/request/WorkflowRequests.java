package Backend.java.request;

import static io.restassured.RestAssured.given;

import Backend.java.payload.WorkflowPayloads;
import Backend.java.resource.Resource;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ru.yandex.qatools.allure.annotations.Step;

public class WorkflowRequests {

  @Step("Create Workflow Request!")
  public static Response createWorkflow(String bearerToken, String name, String description) {
    final String resourcePath = Resource.resource;

    final String requestBody = WorkflowPayloads.buildWorkflowPayload(name, description);

    Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .and()
            .when()
            .post("workflows/")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Create Workflow Task Request!")
  public static Response createWorkflowTask(String bearerToken, String workflowId) {
    final String resourcePath = Resource.resource + "workflows/" + workflowId;

    final String requestBody = WorkflowPayloads.buildWorkflowPayloadTask();

    Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .and()
            .when()
            .post("tasks/")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Create Workflow Jobs Request!")
  public static Response createWorkflowJobs(String bearerToken, String workflowId) {
    final String resourcePath = Resource.resource + "workflows/" + workflowId;

    final String requestBody = WorkflowPayloads.buildWorkflowPayloadJobs();

    Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .and()
            .when()
            .post("jobs/")
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Get Workflow jobs Request!")
  public static Response getWorkflowJobs(String bearerToken, String jobId) {
    final String resourcePath = Resource.resource + "jobs/" + jobId;

    Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .and()
            .when()
            .get()
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }

  @Step("Delete Workflow Request!")
  public static Response deleteWorkflow(String bearerToken, String workflowId) {
    final String resourcePath = Resource.resource + "workflows/" + workflowId;

    Response response =
        given()
            .baseUri(resourcePath)
            .auth()
            .oauth2(bearerToken)
            .and()
            .when()
            .delete()
            .then()
            .log()
            .body()
            .and()
            .extract()
            .response();
    return response;
  }
}
