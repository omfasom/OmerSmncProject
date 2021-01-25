package Backend.java.utils;

import static Common.Logger.logInfo;

import io.restassured.response.Response;

public class Helpers {

  public static String getJobId(Response response) {
    final String jobId = response.jsonPath().getString("data.id");
    logInfo(String.format("JobId is successfully retrieved %s", jobId));
    return jobId;
  }

  public static String getWorkflowId(Response response) {
    final String workflowId = response.jsonPath().getString("data.id");
    logInfo(String.format("Workflow Id is successfully retrieved %s", workflowId));
    return workflowId;
  }
}
