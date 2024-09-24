package main.java.ma.Bati.sc.UI;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.service.IService.IClientService;

import java.sql.SQLException;
import java.util.Scanner;

public class ClientUI {
    private final IClientService clientService ;
    private  final Scanner scanner = new Scanner(System .in);



    public ClientUI(IClientService clientService) {
        this.clientService = clientService;
    }

    public void createClient(){
        System.out.print("enter the name: ");
        String name = scanner.nextLine();
        System.out.println("enter the address: ");
        String address = scanner.nextLine();
        System.out.println("enter the phone number: ");
        String phone = scanner.nextLine();
        System.out.println("is professional (Y/n)");
        boolean isProfessional = Boolean.parseBoolean(scanner.nextLine());

        Client client = new Client(
                name,
                address,
                phone,
                isProfessional

        );
        clientService.create(client);
        System.out.println("client createation done");

    }

}
