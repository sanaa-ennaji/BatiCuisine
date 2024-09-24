package main.java.ma.Bati.sc;

import main.java.ma.Bati.sc.UI.PrincipalMenu;
import main.java.ma.Bati.sc.config.DatabaseConnection;

import java.sql.Connection;
import  java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        try(Connection connection = dbConnection.getConnection())
        {
            if(connection != null){
                System.out.println("setnence croisee!");

                PrincipalMenu principalMenu = new PrincipalMenu();
                principalMenu.Menu();
            }else{
                System.out.println("failed");
            }

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("failed to connect with database");
        }

    }
}