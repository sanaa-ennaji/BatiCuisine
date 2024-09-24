package main.java.ma.Bati.sc;

import main.java.ma.Bati.sc.UI.PrincipalMenu;
import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
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
                IProjectRepository projectRepository = new projectRepository();
                IClientRepository clientRepository = new clientRepository();
                IProjectService projectService = new projectService(projectRepository);
                IClientService clientService = new clientService(clientRepository);

                PrincipalMenu principalMenu = new PrincipalMenu(projectService, clientService);
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