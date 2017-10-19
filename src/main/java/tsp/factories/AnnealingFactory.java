package main.java.tsp.factories;

import lombok.Data;
import main.java.tsp.Annealing;
import main.java.interfaces.Solution;

public @Data class AnnealingFactory {
  private final Double temp;
  private final Double limit;
  private final Double epsilon;
  private final Double phi;

  public Annealing createAnnealing(Solution solution) {
    Annealing a  = new Annealing(epsilon,phi,limit);
    a.setTemp(temp);
    a.setSolution(solution);
    return a;
  }
}
