package main.java.tsp;

import lombok.Data;
import main.java.interfaces.PointCollection;
import java.util.Iterator;
import java.util.LinkedList;

public @Data class Tour implements PointCollection {
  private final LinkedList<City> cities;
  private Double distance = null;
  
  public Double totalDistance() {
      if(distance == null){
        Double dist = 0.0;
        for (int i = 0; i< cities.size() - 1;i++ ) {
          City city1 = cities.get(i);
          City city2 = cities.get(i+1);
          dist+= city1.distanceTo(city2);
        }
        this.distance = dist;
      }
      return this.distance;
  }

  public Tour neighbour() {
    return this;
  }

  public Integer cost(){
    return 1;
  }

  private Tour swap() {
    return this;
  }
}
