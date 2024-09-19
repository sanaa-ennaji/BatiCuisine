package main.java.ma.Bati.sc;

import main.java.ma.Bati.sc.utils.DatabaseConnection;

import java.sql.Connection;
import  java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        try(Connection connection = dbConnection.getConnection())
        {
            System.out.println("setnence croisee!");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("failed to connect with database");
        }

    }
}