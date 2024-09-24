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
        System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) : ");
        boolean applyProfitMargin = scanner.nextLine().equalsIgnoreCase("y");
        Optional<Double> profitMargin = Optional.empty();
        if (applyProfitMargin) {
            System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
            profitMargin = Optional.of(Double.parseDouble(scanner.nextLine()));
        }
        double totalCost = projectService.calculateTotalCost(project, profitMargin);
        project.setTotalCost(totalCost);


        System.out.println("Le coût total du projet est de : " + totalCost + " €");
        printCostBreakdown(project);

    }

    private void printCostBreakdown(Project project) {
        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : " + project.getProjectName());
        System.out.println("Client : " + project.getClient().map(Client::getName).orElse("Inconnu"));
        System.out.println("Adresse du chantier : " + project.getClient().map(Client::getAddress).orElse("Adresse non fournie"));
        System.out.println("Surface : " + project.getSurface() + " m²");
        System.out.println("--- Détail des Coûts ---");

        double totalMaterialCostBeforeVAT = 0;
        double totalMaterialCostWithVAT = 0;
        System.out.println("1. Matériaux :");
        for (Material material : project.getMaterials()) {
            double materialCostBeforeVAT = material.getQuantity() * material.getUnitCost() + material.getTransportCost();
            double materialCostWithVAT = materialCostBeforeVAT * (1 + material.getVATRate() / 100);
            totalMaterialCostBeforeVAT += materialCostBeforeVAT;
            totalMaterialCostWithVAT += materialCostWithVAT;

            System.out.println("- " + material.getName() + " : " + String.format("%.2f", materialCostWithVAT) + " € " +
                    "(quantité : " + material.getQuantity() + " m²/litres, coût unitaire : " + material.getUnitCost() + " €/unité, qualité : " +
                    material.getQualityCoefficient() + ", transport : " + material.getTransportCost() + " €)");
        }
        System.out.println("**Coût total des matériaux avant TVA : " + String.format("%.2f", totalMaterialCostBeforeVAT) + " €**");
        System.out.println("**Coût total des matériaux avec TVA : " + String.format("%.2f", totalMaterialCostWithVAT) + " €**");

        double totalLaborCostBeforeVAT = 0;
        double totalLaborCostWithVAT = 0;
        System.out.println("2. Main-d'œuvre :");
        for (Labor labor : project.getLabors()) {
            double laborCostBeforeVAT = labor.getHourlyRate() * labor.getWorkHours();
            double laborCostWithVAT = laborCostBeforeVAT * (1 + labor.getVATRate() / 100);
            totalLaborCostBeforeVAT += laborCostBeforeVAT;
            totalLaborCostWithVAT += laborCostWithVAT;

            System.out.println("- " + labor.getName() + " : " + String.format("%.2f", laborCostWithVAT) + " € " +
                    "(taux horaire : " + labor.getHourlyRate() + " €/h, heures travaillées : " + labor.getWorkHours() +
                    " h, productivité : " + labor.getWorkEfficiency() + ")");
        }
        System.out.println("**Coût total de la main-d'œuvre avant TVA : " + String.format("%.2f", totalLaborCostBeforeVAT) + " €**");
        System.out.println("**Coût total de la main-d'œuvre avec TVA : " + String.format("%.2f", totalLaborCostWithVAT) + " €**");

        double totalCostBeforeProfit = totalMaterialCostBeforeVAT + totalLaborCostBeforeVAT;
        System.out.println("3. Coût total avant marge : " + String.format("%.2f", totalCostBeforeProfit) + " €");

        project.getProfitMargin().ifPresent(profitMargin -> {
            double marginValue = totalCostBeforeProfit * (profitMargin / 100);
            System.out.println("4. Marge bénéficiaire (" + profitMargin + "%) : " + String.format("%.2f", marginValue) + " €");
            System.out.println("**Coût total final du projet : " + String.format("%.2f", project.getTotalCost()) + " €**");
        });
    }






}
