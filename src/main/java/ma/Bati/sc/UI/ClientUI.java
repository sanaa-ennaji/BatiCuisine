package main.java.ma.Bati.sc.UI;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.service.IService.IClientService;
import java.util.Scanner;

public class ClientUI {
    private final IClientService clientService ;
    private  final Scanner scanner = new Scanner(System .in);



    public ClientUI(IClientService clientService) {
        this.clientService = clientService;
    }

    public void createClient(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Is professional (Y/n): ");
        String isProfessionalInput = scanner.nextLine().trim().toLowerCase();

        boolean isProfessional;
        if (isProfessionalInput.equals("y")) {
            isProfessional = true;
        } else if (isProfessionalInput.equals("n")) {
            isProfessional = false;
        } else {
            System.out.println("Invalid input, defaulting to 'No' (not professional).");
            isProfessional = false;
        }

        Client client = new Client(
                name,
                address,
                phone,
                isProfessional
        );


        clientService.create(client);
        System.out.println("Client creation done.");

    }

}
