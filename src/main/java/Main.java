package main.java;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.ArrayList;
import main.java.tsp.factories.AnnealingFactory;
import main.java.tsp.factories.TourFactory;
import main.java.tsp.Annealing;
import main.java.tsp.Tour;

public class Main {
  public static void main(String[] args) {
    try{

      YamlReader reader = new YamlReader(new FileReader("./src/app.yaml"));
      Object object = reader.read();
      Map map = (Map)object;
      Double punishment = 100000.0;
      Tour tour = new TourFactory((ArrayList<String>)map.get("Cities"), punishment).makeTour();
      // System.out.println(tour.toString());
      // System.out.println(tour.totalDistance());
      System.out.print("I'm not work for this moment");
    }catch(FileNotFoundException e){
      System.err.println(e.getMessage());
    }catch(YamlException e){
      System.err.println(e.getMessage());
    }
  }
}
