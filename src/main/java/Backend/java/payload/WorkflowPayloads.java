package Backend.java.payload;

import static Backend.java.builder.WorkflowBuilder.createWorkflow;
import static Backend.java.builder.WorkflowJobsBuilder.createWorkflowJobs;
import static Backend.java.builder.WorkflowTaskBuilder.createWorkflowTask;

import Backend.java.builder.WorkflowBuilder;
import Backend.java.builder.WorkflowJobsBuilder;
import Backend.java.builder.WorkflowTaskBuilder;
import Backend.java.model.Workflow;
import java.util.List;

public class WorkflowPayloads {
  public static String buildWorkflowPayload(String name, String description) {
    Workflow workflow = createWorkflow(name, description);
    return WorkflowBuilder.getJsonPayload(workflow);
  }

  public static String buildWorkflowPayloadTask() {
    List<Workflow> workflowList = createWorkflowTask();
    return WorkflowTaskBuilder.getJsonPayload(workflowList);
  }

  public static String buildWorkflowPayloadJobs() {
    Workflow workflow = createWorkflowJobs();
    return WorkflowJobsBuilder.getJsonPayload(workflow);
  }


}
