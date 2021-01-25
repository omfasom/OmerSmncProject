package projects;

import static Backend.java.request.WorkflowRequests.deleteWorkflow;
import static Backend.java.request.WorkflowRequests.getWorkflowJobs;
import static Backend.java.utils.Helpers.getJobId;
import static Backend.java.utils.Helpers.getWorkflowId;
import static Common.CustomFunctions.generateBearerToken;

import Backend.java.request.WorkflowRequests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

public class APITest {

  @Test
  @Description("Create Workflow")
  public void testCreatingWorkflow() {
    final String bearerToken = generateBearerToken();
    // Create Workflow
    Response response =
        WorkflowRequests.createWorkflow(
            bearerToken, "QA coding challenge workflow", "Workflow description");
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "QA coding challenge workflow is not created!");
    // Delete Workflow
    final String workflowId = getWorkflowId(response);
    response = deleteWorkflow(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 204, "Deleting Workflow jobs request is not successful!");
  }

  @Test
  @Description("Create Workflow Task")
  public void testCreatingWorkflowTask() {
    final String bearerToken = generateBearerToken();
    // Create Workflow
    Response response =
        WorkflowRequests.createWorkflow(
            bearerToken, "QA coding challenge workflow", "Workflow description");
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "QA coding challenge workflow is not created!");
    // Add Task to Workflow
    final String workflowId = getWorkflowId(response);
    response = WorkflowRequests.createWorkflowTask(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "Creating Workflow task request is not successful!");
    // Delete Workflow
    response = deleteWorkflow(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 204, "Deleting Workflow jobs request is not successful!");
  }

  @Test
  @Description("Create Workflow Jobs")
  public void testCreatingWorkflowJobs() {
    final String bearerToken = generateBearerToken();
    // Create Workflow
    Response response =
        WorkflowRequests.createWorkflow(
            bearerToken, "QA coding challenge workflow", "Workflow description");
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "QA coding challenge workflow is not created!");
    // Add Task to Workflow
    final String workflowId = getWorkflowId(response);
    response = WorkflowRequests.createWorkflowTask(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "Creating Workflow task request is not successful!");
    // Create and Run a Job
    response = WorkflowRequests.createWorkflowJobs(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "Creating Workflow jobs request is not successful!");
    // Get the Job for verification
    final String jobId = getJobId(response);
    response = getWorkflowJobs(bearerToken, jobId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200, "Getting Workflow jobs request is not successful!");
    // Delete Workflow
    response = deleteWorkflow(bearerToken, workflowId);
    statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 204, "Deleting Workflow jobs request is not successful!");
  }
}
