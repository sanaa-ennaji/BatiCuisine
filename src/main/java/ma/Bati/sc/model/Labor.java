package main.java.ma.Bati.sc.model;

import java.util.UUID;

public class Labor extends Component  {
  private double hourlyRate ;
  private double workHours ;
  private double workEfficiency;


    public Labor(UUID id, String name, double VATRate, Project project, double hourlyRate, double WorkHours , double workEfficiency) {
        super(id, name, VATRate, project);
        this.setHourlyRate(hourlyRate);
        this.setWorkHours(WorkHours);
        this.setWorkEfficiency(workEfficiency);

    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        this.workHours = workHours;
    }

    public double getWorkEfficiency() {
        return workEfficiency;
    }

    public void setWorkEfficiency(double workEfficiency) {
        this.workEfficiency = workEfficiency;
    }
}
