package main.java.tsp.factories;

// import lombok.Data;
import main.java.tsp.Tour;
import main.java.tsp.City;
import java.util.ArrayList;
import java.util.LinkedList;

public class TourFactory {
  private final ArrayList<String> citiesId;
  private final Double punishment;
  // private LinkedList<City> cities;

  public TourFactory(ArrayList<String> citiesId,Double punishment){
    this.punishment = punishment;
    this.citiesId = citiesId;
  }

  public Tour makeTour() {
    LinkedList<City> cities = new LinkedList<>();
    CityFactory factory = new CityFactory(punishment);
    for (String city : citiesId) {
      Integer cityId = Integer.parseInt(city);
      City newCity = factory.createCity(cityId);
      cities.add(newCity);
    }
    return new Tour(cities);
  }
}
