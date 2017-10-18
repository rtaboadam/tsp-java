package main.java.utils;

import lombok.Getter;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMatrix {
  private static CityMatrix instance = null;
  private @Getter HashMap<String,Object>[][] matrix;
  private DatabaseHandle dbHandle;
  private Integer citiesLength;

  protected CityMatrix() throws SQLException{
    this.dbHandle = DatabaseHandle.getInstance();
    ResultSet rs = this.dbHandle.getStatement().executeQuery("SELECT COUNT(*) FROM cities");
    while(rs.next()){
      this.citiesLength = rs.getInt(1);
    }
    this.matrix = new HashMap[citiesLength+1][citiesLength+1];
    fillMatrix();
  }

  private void fillMatrix(){
    try {
      for (int i=1; i<=this.citiesLength; i++) {
        String query = String.format("SELECT * FROM connections WHERE id_city_1 = %s", i);
        ResultSet rs = this.dbHandle.getStatement().executeQuery(query);
        while(rs.next()){
          int idCity1 = i;
          int idCity2 = rs.getInt("id_city_2");
          HashMap<String,Object> hmap = new HashMap<>();
          hmap.put("id_city_1",rs.getInt("id_city_1"));
          hmap.put("id_city_2",rs.getInt("id_city_2"));
          hmap.put("distance",rs.getDouble("distance"));
          this.matrix[idCity1][idCity2] = hmap;
        }
      }
    } catch (SQLException e){
      System.err.println(e.getMessage());
    }
  }

  public static CityMatrix getInstance() {
    if (instance == null){
      try {
        instance = new CityMatrix();
      }catch( SQLException e) {
        System.err.println(e.getMessage());
      }
    }
    return instance;
  }
}
