package main.java;

import main.java.utils.DatabaseHandle;
import main.java.utils.CityMatrix;
import main.java.tsp.factories.CityFactory;
import main.java.tsp.City;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) throws SQLException{
    CityFactory a = new CityFactory();
    City b = a.createCity(1);
    System.out.println(b.toString());
    // CityMatrix a = CityMatrix.getInstance();
    // CityMatrix b = CityMatrix.getInstance();
    // System.out.println(a.hashCode());
    // System.out.println(b.hashCode());
    // System.out.println(a.getMatrix()[1][7]);
    // DatabaseHandle a = DatabaseHandle.getInstance();
    // ResultSet rs = a.getStatement().executeQuery("SELECT * FROM cities LIMIT 5");
    // while(rs.next()){
    //   System.out.println("name = "+ rs.getString("name"));
    // }
  }
}


// import lombok.Data;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
//
// public @Data class Main {
//   private final String name;
//   private final double latitude, longitude;
//   private String county;
//
//   public static void main(String[] args) {
//     Main a = new Main("a",1.0,2.0);
//     System.out.println("Hello Ricardo");
//     System.out.println(a.toString());
//     System.out.println(a.getLatitude());
//     System.out.println(a.getLongitude());
//     System.out.println(a.getName());
//   }
// }
