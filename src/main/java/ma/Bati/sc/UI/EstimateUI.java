package main.java.ma.Bati.sc.UI;

import main.java.ma.Bati.sc.model.Estimate;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.service.IService.IEstimateService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;

public class EstimateUI {

    private final IEstimateService estimateService;
    private final Scanner scanner = new Scanner(System.in);

    public EstimateUI(IEstimateService estimateService) {
        this.estimateService = estimateService;
    }

    public void createEstimate(Project project, double totalCost) {
        System.out.println("Coût total final du projet : " + String.format("%.2f", totalCost) + " €");

        System.out.println("--- Enregistrement du Devis ---");
        LocalDate issueDate = getValidDate("Entrez la date d'émission du devis (format : jj/mm/aaaa) : ");
        LocalDate validatyDate = getValidDate("Entrez la date de validité du devis (format : jj/mm/aaaa) : ");
        System.out.print("Souhaitez-vous enregistrer le devis ? (y/n) : ");
        String saveDecision = scanner.nextLine().trim().toLowerCase();

        if (saveDecision.equals("y")) {
            Estimate estimate = new Estimate(UUID.randomUUID(), totalCost, issueDate, validatyDate, false, project);
            estimateService.create(estimate);
            System.out.println("Devis enregistré avec succès !");
        } else {
            System.out.println("Devis non enregistré.");
        }

        System.out.println("--- Fin du projet ---");
    }

    private LocalDate getValidDate(String prompt) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();

            try {
                date = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Format de date invalide. Veuillez entrer une date au format jj/mm/aaaa.");
            }
        }

        return date;
    }
}

