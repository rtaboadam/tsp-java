package main.java.tsp.factories;

import lombok.Data;
import main.java.utils.DatabaseHandle;
import main.java.tsp.City;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityFactory {
  private final DatabaseHandle dbHandle = DatabaseHandle.getInstance();
  private final Double punishment;

  public CityFactory(Double punishment){
    this.punishment = punishment;
    City.punishment = punishment;
  }

  public City createCity(int id){
    try{
      String query = String.format("SELECT * FROM cities WHERE id = %s", id);
      ResultSet rs = dbHandle.getStatement().executeQuery(query);
      while(rs.next()){
        int id_ = rs.getInt("id");
        String name = rs.getString("name");
        String country = rs.getString("country");
        Double latitude = rs.getDouble("latitude");
        Double longitude = rs.getDouble("longitude");
        // Integer population = rs.getInt("population");
        return new City(id_,name,country,latitude,longitude);
      }
    }catch (SQLException e){
      System.err.println(e.getMessage());
    }
    return null;
  }
}
