package main.java.ma.Bati.sc.UI;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Material;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.service.IService.IClientService;
import main.java.ma.Bati.sc.service.IService.IProjectService;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

public class ProjectUI {

    private  final IProjectService projectService;
    private final Scanner scanner;
    private final IClientService clientService ;

    public ProjectUI(IProjectService projectService) {
        this.projectService = projectService;
        this.scanner = new Scanner(System.in);
        this.clientService = clientService ;
    }

    public void createProject() {
        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet : ");
        String projectName = scanner.nextLine();

        System.out.print("Entrez la surface de la cuisine (en m²) : ");
        double surface = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter client ID: ");
        UUID clientId = UUID.fromString(scanner.nextLine());
        Optional<Client> client = clientService.findById(clientId);

        Project project = projectService.create(projectName, surface, client);

//        addMaterials(project);
//
//        addLabor(project);
//
//        calculateTotalCost(project);

        try {
            projectService.save(project);
            System.out.println("project add  done ");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error saving the project ");
        }
    }

    private void addMaterials(Project project) {
        boolean addMoreMaterials = true;
        while (addMoreMaterials) {
            System.out.println("--- Ajout des matériaux ---");
            System.out.print("Entrez le nom du matériau : ");
            String materialName = scanner.nextLine();

            System.out.print("Entrez la quantité de ce matériau (en m² ou litres) : ");
            double quantity = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le coût unitaire de ce matériau (€) : ");
            double unitCost = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le coût de transport de ce matériau (€) : ");
            double transportCost = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le coefficient de qualité du matériau (1.0 = standard, > 1.0 = haute qualité) : ");
            double qualityCoefficient = Double.parseDouble(scanner.nextLine());


            Material material = new Material(name, quantity, unitCost, transportCost, qualityCoefficient, project_id);
            project.addMaterial(material);

            System.out.println("Matériau ajouté avec succès !");

            System.out.print("Voulez-vous ajouter un autre matériau ? (y/n) : ");
            addMoreMaterials = scanner.nextLine().equalsIgnoreCase("y");
        }
    }
    }




}
