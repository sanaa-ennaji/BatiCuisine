package main.java.ma.Bati.sc.model;

import main.java.ma.Bati.sc.Enums.ProjectState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Project {
   private UUID id;
    private String projectName ;
    private double profitMargin ;
    private double totalCost ;
    private ProjectState projectState ;
    private double surface ;
    private Optional<Client> client ;
    List<Component> components ;
    List<Estimate> estimates ;
    private List<Material> materials;
    private List<Labor> labors;


    public Project (){

    }

    public Project (UUID id, String projectName, double profitMargin, double totalCost , ProjectState projectState,double surface, Client client, List<Material> materials, List<Labor> labors){
       this.setId(id) ;
       this.setProjectName(projectName);
       this.setProfitMargin(profitMargin);
       this.setTotalCost(totalCost);
       this.setProjectState(projectState);
       this.setSurface(surface);
       this.setClient(Optional.ofNullable(client));
        this.materials = new ArrayList<>();
        this.labors = new ArrayList<>();


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
   public Optional<Client> getClient (){
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
    public void setClient (Optional<Client> client){
        this.client = client ;
    }
    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public void setLabors(List<Labor> labors) {
        this.labors = labors;
    }
    public List<Material> getMaterials() {
        if (materials == null) {
            materials = new ArrayList<>();
        }
        return materials;
    }


    public List<Labor> getLabors() {
        if(labors == null){
            labors = new ArrayList<>();
        }
        return  labors ;
    }



}
