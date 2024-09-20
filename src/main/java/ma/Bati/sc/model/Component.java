package main.java.ma.Bati.sc.model;

import java.util.UUID;

public class Component {

private UUID id;
private String name ;
private double VATRate ;
private Project project;


public Component (UUID id, String name, double VATRate, Project project){
this.setId(id);
this.setName(name);
this.setVATRate(VATRate);
this.setProject(project);
}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getVATRate() {
        return VATRate;
    }

    public Project getProject() {
        return project;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVATRate(double VATRate) {
        this.VATRate = VATRate;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
