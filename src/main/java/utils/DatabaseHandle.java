package main.java.utils;

import lombok.Data;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public @Data class DatabaseHandle {
  private static DatabaseHandle instance = null;
  private Connection connection;
  private Statement statement;
  protected DatabaseHandle(){
    try {
      String dbName = Paths.get("./resources/world.sqlite")
                           .toAbsolutePath()
                           .normalize()
                           .toString();
      System.out.println(dbName);
      System.out.println(String.format("jdbc:sqlite:%s",dbName));
      this.connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s",dbName));
      this.statement = connection.createStatement();
      this.statement.setQueryTimeout(30);
    }catch(SQLException e){
      // if the error message is "out of memory"
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
  }

  public static DatabaseHandle getInstance() {
    if(instance == null) {
      instance = new DatabaseHandle();
    }
    return instance;
  }
}
