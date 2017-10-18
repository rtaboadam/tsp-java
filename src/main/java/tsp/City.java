package main.java.tsp;

import lombok.Data;
import main.java.interfaces.Point;

public @Data class City implements Point {
  public final Integer id;
  public final String name;
  public final String country;
  public final Double latitude, longitude;

  public Double distanceTo(Point p) {
    if(p instanceof City) {
      return new Double(1);
    }
    return new Double(Double.NaN);
  }
}
