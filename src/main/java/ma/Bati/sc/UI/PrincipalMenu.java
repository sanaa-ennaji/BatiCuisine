package main.java.ma.Bati.sc.UI;

import java.sql.SQLException;
import java.util.Scanner;

public class PrincipalMenu {

private final Scanner scanner =  new Scanner(System.in);

public PrincipalMenu (){

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
             System.out.println("still working on it");
             break;

         default:
             System.out.println("invalid choice");
             Menu();

     }

    }

    }


}
