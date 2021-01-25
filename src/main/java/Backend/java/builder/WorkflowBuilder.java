package Backend.java.builder;

import Backend.java.model.Workflow;
import com.google.gson.Gson;

public class WorkflowBuilder {
  public static String getJsonPayload(Workflow workflow) {
    Gson gson = new Gson();
    return gson.toJson(workflow, Workflow.class);
  }

  public static Workflow createWorkflow(String name, String description) {
    Workflow workflow = new Workflow();
    workflow.setName(name);
    workflow.setDescription(description);
    return workflow;
  }
}
