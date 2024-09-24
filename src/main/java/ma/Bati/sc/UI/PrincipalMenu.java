package main.java.ma.Bati.sc.UI;


import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;
import main.java.ma.Bati.sc.repository.Interfaces.ILaborRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
import main.java.ma.Bati.sc.repository.clientRepository;
import main.java.ma.Bati.sc.repository.laborRepository;
import main.java.ma.Bati.sc.repository.materialRepository;
import main.java.ma.Bati.sc.repository.projectRepository;
import main.java.ma.Bati.sc.service.IService.IClientService;
import main.java.ma.Bati.sc.service.IService.IProjectService;
import main.java.ma.Bati.sc.service.clientService;
import main.java.ma.Bati.sc.service.projectService;

import java.sql.SQLException;
import java.util.Scanner;

public class PrincipalMenu {
private  final ProjectUI projectUI;
private  final ClientUI clientUI;
    private final Scanner scanner =  new Scanner(System.in);

public PrincipalMenu (){
    IProjectRepository projectRepository = new projectRepository();
    IClientRepository clientRepository = new clientRepository();
    IMaterialRepository materialRepository = new materialRepository();
    ILaborRepository laborRepository = new laborRepository();
    IProjectService projectService = new projectService(projectRepository , materialRepository, laborRepository);
    IClientService clientService = new clientService(clientRepository);
    this.clientUI = new ClientUI(clientService);
    this.projectUI = new ProjectUI(projectService, clientService);
}

public void  Menu () throws SQLException{
    while(true){
        System.out.println("=========================Welcome to the kitchen renovation project management application============================");

        System.out.println("||==========principal Menu==============||");
        System.out.println("||1 - add a new client                  ||");
        System.out.println("||2 - create a new project              ||");
        System.out.println("||3 - view existing projects            ||");
        System.out.println("||4 - calculate the cost of projects    ||");
        System.out.println("||======================================||");
        System.out.print("enter your choice :");
     int choice = scanner.nextInt();
     scanner.nextLine();

     switch(choice){

         case 1:
             clientUI.createClient();

             break;
         case 2:
             projectUI.createProject();

         default:
             System.out.println("invalid choice");
             Menu();

     }

    }

    }


}
