package main.java.tsp;

import lombok.Data;
import main.java.interfaces.Point;
import main.java.utils.CityMatrix;

public @Data class City implements Point {
  public static Double punishment;
  public final Integer id;
  public final String name;
  public final String country;
  public final Double latitude, longitude;

  public Double distanceTo(Point p) {
    try {
      if(p instanceof City) {
        City c = (City)p;
        return (Double)(CityMatrix.getInstance()
                        .getMatrix()[this.getId()][c.getId()]
                        .get("distance"));
      }
    }catch(NullPointerException e){
      return City.punishment;
    }
    return new Double(Double.NaN);
  }

}
