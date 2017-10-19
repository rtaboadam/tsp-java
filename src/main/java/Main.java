package main.java;

import main.java.tsp.Annealing;
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
      new Annealing();
  }
}
