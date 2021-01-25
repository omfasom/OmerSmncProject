package Backend.java.builder;

import Backend.java.model.Workflow;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class WorkflowTaskBuilder {
  public static String getJsonPayload(List<Workflow> workflowList) {
    Gson gson = new Gson();
    return gson.toJson(workflowList);
  }

  public static List<Workflow> createWorkflowTask() {
    List<Workflow> workflowList = new ArrayList<>();
    Workflow workflow1 = new Workflow();
    workflow1.setName("nasa-modis:1");
    workflow1.setParentName("null");
    workflow1.setBlockId("ef6faaf5-8182-4986-bce4-4f811d2745e5");
    workflowList.add(workflow1);

    Workflow workflow2 = new Workflow();
    workflow2.setName("sharpening:1");
    workflow2.setParentName("nasa-modis:1");
    workflow2.setBlockId("e374ea64-dc3b-4500-bb4b-974260fb203e");
    workflowList.add(workflow2);
    return workflowList;
  }
}
