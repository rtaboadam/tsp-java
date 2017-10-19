package main.java.tsp;

import lombok.Data;
import java.util.HashMap;
import main.java.interfaces.Solution;

public @Data class Annealing{
  private final Double punishment;
  private final Double limit;
  private final Double epsilon;
  private final Double cold;
  private Solution solution;
  private Double temp;

  public HashMap<String,Object> calculaLote(){
    int c = 0;
    double r = 0.0;
    while(c < limit){
      Solution solution_vec = solution.neighbour();
      if(solution_vec.cost() <= solution.cost() + temp){
        this.setSolution(solution_vec);
        ++c;
        r+= solution_vec.cost();
      }
    }
    HashMap<String,Object> tuple = new HashMap<>();
    tuple.put("promedio", r/limit);
    tuple.put("solution", solution);
    return tuple;
  }

  public void aceptacionPorUmbrales(){
    int p = 0;
    int q = Integer.MAX_VALUE;
    while(temp > epsilon){
      int p_prima = q;
      while(p <= p_prima){
        p_prima = p;
        HashMap<String,Object> tuple = this.calculaLote();
        q = p;
      }

      this.setTemp(this.getTemp()*this.getCold());
    }
  }
}
