package main.java.ma.Bati.sc.UI;


import main.java.ma.Bati.sc.repository.Interfaces.*;
import main.java.ma.Bati.sc.repository.clientRepository;
import main.java.ma.Bati.sc.repository.laborRepository;
import main.java.ma.Bati.sc.repository.materialRepository;
import main.java.ma.Bati.sc.repository.projectRepository;
import main.java.ma.Bati.sc.repository.estimateRepository;
import main.java.ma.Bati.sc.service.EstimateService;
import main.java.ma.Bati.sc.service.IService.IClientService;
import main.java.ma.Bati.sc.service.IService.IEstimateService;
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

   IEstimateRepository estimateRepository= new estimateRepository();
    IEstimateService estimateService = new EstimateService(estimateRepository);


    IProjectService projectService = new projectService(projectRepository , materialRepository, laborRepository);
    IClientService clientService = new clientService(clientRepository);
    this.clientUI = new ClientUI(clientService);
    this.projectUI = new ProjectUI(projectService, clientService , estimateService);
}

public void  Menu () throws SQLException{
    while(true){
        System.out.println("=========================Welcome to the kitchen renovation project management application============================");

        System.out.println("||==========principal Menu==============||");
        System.out.println("||1 - add a new client                  ||");
        System.out.println("||2 - create a new project              ||");
        System.out.println("||3 - view existing projects            ||");
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
             break ;
         case 3:
            projectUI.displayAllProjects();
            break;
         default:
             System.out.println("invalid choice");
             Menu();

     }

    }

    }


}
