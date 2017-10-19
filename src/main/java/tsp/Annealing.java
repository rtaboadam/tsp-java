package main.java.tsp;

import lombok.Data;
import java.util.HashMap;
import main.java.interfaces.Solution;

public @Data class Annealing{
  private final Double epsilon;
  private final Double phi;
  private final Double limit;
  private Solution solution;
  private Double temp;
  
}
