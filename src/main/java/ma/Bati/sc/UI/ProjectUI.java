package main.java.ma.Bati.sc.UI;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Labor;
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
    private final IClientService clientService;

    public ProjectUI(IProjectService projectService, IClientService clientService) {
        this.projectService = projectService;
        this.scanner = new Scanner(System.in);
        this.clientService = clientService;
    }

    public void createProject() {
        System.out.println("--- Creation d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet : ");
        String projectName = scanner.nextLine();

        System.out.print("Entrez la surface de la cuisine (en m²) : ");
        double surface = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter client ID: ");
        UUID clientId = UUID.fromString(scanner.nextLine());
        Optional<Client> client = clientService.findById(clientId);

        Project project = projectService.create(projectName, surface, client);

       addMaterials(project);

        addLabor(project);

        calculateTotalCost(project);

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


            System.out.print("Entrez le taux de TVA (%) : ");
            double VATRate = Double.parseDouble(scanner.nextLine());


            UUID id = UUID.randomUUID();


            Material material = new Material(id, materialName, VATRate, project, quantity, unitCost, transportCost, qualityCoefficient);


            projectService.addMaterialToProject(project, material);

            System.out.println("Materiau ajouté avec succes !");


            System.out.print("Voulez-vous ajouter un autre matériau ? (y/n) : ");
            addMoreMaterials = scanner.nextLine().equalsIgnoreCase("y");
        }
    }


    private void addLabor(Project project) {
        boolean addMoreLabor = true;
        while (addMoreLabor) {
            System.out.println("--- Ajout de la main-d'œuvre ---");

            System.out.print("Entrez le type de main-d'œuvre (e.g., Ouvrier de base, Spécialiste) : ");
            String laborType = scanner.nextLine();

            System.out.print("Entrez le taux horaire de cette main-d'œuvre (€/h) : ");
            double hourlyRate = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le nombre d'heures travaillées : ");
            double hoursWorked = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) : ");
            double productivityFactor = Double.parseDouble(scanner.nextLine());

            System.out.print("Entrez le taux de TVA (%) : ");
            double VATRate = Double.parseDouble(scanner.nextLine());


            UUID id = UUID.randomUUID();

            Labor labor = new Labor(id, laborType, VATRate, project, hourlyRate, hoursWorked, productivityFactor);

            projectService.addLaborToProject(project, labor);

            System.out.println("Main-d'œuvre ajoutée avec succès !");


            System.out.print("Voulez-vous ajouter un autre type de main-d'œuvre ? (y/n) : ");
            addMoreLabor = scanner.nextLine().equalsIgnoreCase("y");
        }
    }
    private void calculateTotalCost(Project project) {
        System.out.println("--- Calcul du coût total ---");

        System.out.print("Souhaitez-vous appliquer une TVA au projet ? (y/n) : ");
        boolean applyVAT = scanner.nextLine().equalsIgnoreCase("y");
        Optional<Double> vatRate = Optional.empty();
        if (applyVAT) {
            System.out.print("Entrez le pourcentage de TVA (%) : ");
            vatRate = Optional.of(Double.parseDouble(scanner.nextLine()));
        }

        System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) : ");
        boolean applyProfitMargin = scanner.nextLine().equalsIgnoreCase("y");
        Optional<Double> profitMargin = Optional.empty();
        if (applyProfitMargin) {
            System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
            profitMargin = Optional.of(Double.parseDouble(scanner.nextLine()));
        }

        double totalCost = projectService.calculateTotalCost(project, vatRate, profitMargin);
        project.setTotalCost(totalCost);

        System.out.println("Le coût total du projet est de : " + totalCost + " €");
    }





}
