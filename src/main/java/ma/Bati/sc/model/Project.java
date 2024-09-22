package main.java.ma.Bati.sc.model;

import main.java.ma.Bati.sc.Enums.ProjectState;

import java.util.List;
import java.util.UUID;

public class Project {
   private UUID id;
    private String projectName ;
    private double profitMargin ;
    private double totalCost ;
    private ProjectState projectState ;
    private double surface ;
    private  Client client ;

    List<Component> components ;
    List<Estimate> estimates ;


    public Project (){

    }

    public Project (UUID id, String projectName, double profitMargin, double totalCost , ProjectState projectState,double surface, Client client){
       this.setId(id) ;
       this.setProjectName(projectName);
       this.setProfitMargin(profitMargin);
       this.setTotalCost(totalCost);
       this.setProjectState(projectState);
       this.setSurface(surface);
       this.setClient(client);


    }

    public UUID getId(){
        return id;
    }
    public String getProjectName(){
        return projectName;
    }
    public double getProfitMargin(){
        return profitMargin ;
    }
    public double getTotalCost(){
        return totalCost;
    }
    public ProjectState getProjectState(){
        return projectState;
    }
   public Client getClient (){
        return client ;
   }
    public void setId (UUID id){
        this.id = id ;

    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public void setProfitMargin(double profitMargin){
        this.profitMargin = profitMargin;
    }
    public void setProjectState(ProjectState projectState){
        this.projectState = projectState ;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public void setClient (Client client){
        this.client = client ;
    }

}
