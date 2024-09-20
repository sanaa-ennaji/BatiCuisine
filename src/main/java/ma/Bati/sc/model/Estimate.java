package main.java.ma.Bati.sc.model;

import java.time.LocalDate;
import java.util.UUID;

public class Estimate {

    private UUID id ;
    private double estimatedAmount ;
    private LocalDate issueDate;
    private LocalDate validatyDate;
    private boolean accepted;

    public Estimate (){

    }
    public Estimate (UUID id , double estimatedAmount, LocalDate issueDate, LocalDate validatyDate, boolean accepted){
        this.setId(id);
        this.setEstimatedAmount(estimatedAmount);
        this.setIssueDate(issueDate);
        this.setValidatyDate(validatyDate);
        this.setAccepted(accepted);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public double getEstimatedAmount() {
        return estimatedAmount;
    }

    public void setEstimatedAmount(double estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public LocalDate getValidatyDate() {
        return validatyDate;
    }

    public void setValidatyDate(LocalDate validatyDate) {
        this.validatyDate = validatyDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }
}

