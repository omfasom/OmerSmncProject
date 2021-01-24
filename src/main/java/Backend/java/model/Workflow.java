package Backend.java.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Workflow {
  private String name = null;
  private String description = null;
  private String parentName = null;
  private String blockId = null;
  @SerializedName("nasa-modis:1")
  public NasaModis1 nasaModis1;
  @SerializedName("sharpening:1")
  public Sharpening1 sharpening1;



}
