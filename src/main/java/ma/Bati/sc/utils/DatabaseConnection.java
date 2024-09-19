package main.java.ma.Bati.sc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

private static DatabaseConnection instance ;
    private Connection connection ;

    private DatabaseConnection() {
        try {
           this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BatiCuisine" , "postgres" , "password" );
        } catch(SQLException e){
            System.out.println("error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnection getInstance (){
      if(instance == null){
          instance = new DatabaseConnection();
      }
        return instance ;
    }

    public Connection getConnection(){
        return connection;
    }

}
