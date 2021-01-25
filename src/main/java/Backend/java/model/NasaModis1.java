package Backend.java.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NasaModis1 {
  private String time = null;
  private Integer limit = null;
  private Integer zoom_level = null;
  private Sharpening1 sharpening = null;
  private List<String> imagery_layers = null;
  private List<Double> bbox = null;
}
