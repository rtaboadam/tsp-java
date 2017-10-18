package main.java.tsp;

import lombok.Data;
import main.java.interfaces.PointCollection;
import java.util.Iterator;
import java.util.LinkedList;

public @Data class Tour implements PointCollection {
  public final LinkedList<City> cities;

  public Double totalDistance() {
    return new Double(-1);
  }

  public Tour neighbour() {
    return this;
  }

  private Tour swap() {
    return this;
  }
}
