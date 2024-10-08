package main.java.ma.Bati.sc.model;

import java.util.UUID;

public class Material extends Component {

    private double quantity ;
    private double uniCost;
    private double transportCost;
    private double qualityCoefficient;


    public Material (UUID id ,String name , double VATRate, Project project , double quantity , double unitCost,double transportCost,  double qualityCoefficient){
        super(id , name , VATRate, project);
        this.setQuantity(quantity);
        this.setUniCost(unitCost);
        this.setTransportCost(transportCost);
        this.setQualityCoefficient(qualityCoefficient);


    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return uniCost;
    }

    public void setUniCost(double uniCost) {
        this.uniCost = uniCost;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }

    public double calculateTotalCost() {
        return (quantity * uniCost + transportCost) * qualityCoefficient;
    }

}
