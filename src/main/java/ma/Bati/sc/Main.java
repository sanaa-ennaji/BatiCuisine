package main.java.ma.Bati.sc;

import main.java.ma.Bati.sc.UI.PrincipalMenu;
import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;
import main.java.ma.Bati.sc.repository.Interfaces.ILaborRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
import main.java.ma.Bati.sc.repository.laborRepository;
import main.java.ma.Bati.sc.repository.materialRepository;
import main.java.ma.Bati.sc.service.IService.IClientService;
import main.java.ma.Bati.sc.service.IService.IProjectService;
import main.java.ma.Bati.sc.service.clientService;
import main.java.ma.Bati.sc.service.projectService;
import main.java.ma.Bati.sc.repository.projectRepository;
import main.java.ma.Bati.sc.repository.clientRepository;

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