package main.java.ma.Bati.sc.UI;


import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
import main.java.ma.Bati.sc.service.IService.IClientService;
import main.java.ma.Bati.sc.service.IService.IProjectService;

import java.sql.SQLException;
import java.util.Scanner;

public class PrincipalMenu {
private  final ProjectUI projectUI;
private final Scanner scanner =  new Scanner(System.in);

public PrincipalMenu (IProjectService projectService, IClientService clientService){

    this.projectUI = new ProjectUI(projectService, clientService);
}

public void  Menu () throws SQLException{
    while(true){
        System.out.println("=========================Welcome to the kitchen renovation project management application============================");
        System.out.println("||==========principal Menu==========||");
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

             projectUI.createProject();

             break;

         default:
             System.out.println("invalid choice");
             Menu();

     }

    }

    }


}
