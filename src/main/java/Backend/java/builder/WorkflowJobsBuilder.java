package Backend.java.builder;

import Backend.java.model.NasaModis1;
import Backend.java.model.Sharpening1;
import Backend.java.model.Workflow;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class WorkflowJobsBuilder {
  public static String getJsonPayload(Workflow workflow) {
    Gson gson = new Gson();
    return gson.toJson(workflow, Workflow.class);
  }

  public static Workflow createWorkflowJobs() {
    Workflow workflow = new Workflow();
    createNasaModis(workflow);
    createSharpening(workflow);
    return workflow;
  }

  public static void createNasaModis(Workflow workflow) {
    NasaModis1 nasaModis = new NasaModis1();
    nasaModis.setTime("2018-12-01T00:00:00+00:00/2020-12-31T23:59:59+00:00");
    nasaModis.setLimit(1);
    nasaModis.setZoom_level(9);
    List<String> imagery_layers = new ArrayList<>();
    imagery_layers.add("MODIS_Terra_CorrectedReflectance_TrueColor");
    nasaModis.setImagery_layers(imagery_layers);
    List<Double> bbox = new ArrayList<>();
    bbox.add(13.365373);
    bbox.add(52.49582);
    bbox.add(13.385796);
    bbox.add(52.510455);
    nasaModis.setBbox(bbox);
    workflow.setNasaModis1(nasaModis);
  }

  public static void createSharpening(Workflow workflow) {
    Sharpening1 sharpening = new Sharpening1();
    sharpening.setStrength("medium");
    workflow.setSharpening1(sharpening);
  }
}
