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
    private  Client client ;
    List<Component> components ;
    List<Estimate> estimates ;


    public Project (){

    }

    public Project (UUID id, String projectName, double profitMargin, double totalCost , ProjectState projectState, Client client){
       this.setId(id) ;
       this.setProjectName(projectName);
       this.setProfitMargin(profitMargin);
       this.setTotalCost(totalCost);
       this.setProjectState(projectState);
       this.setClient(client);


    }

    public UUID getId(){
        return id;
    }
    public String getProjectName(){
        return projectName;
    }
    public double getProfitMargin(){
        return
    }
}
