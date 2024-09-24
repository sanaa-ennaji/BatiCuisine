package main.java.ma.Bati.sc.service.IService;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Labor;
import main.java.ma.Bati.sc.model.Material;
import main.java.ma.Bati.sc.model.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectService
{
    Project create(String projectName, double surface, Optional<Client> client);
    void save (Project project) throws SQLException;
    double calculateTotalCost(Project project, Optional<Double> VATRate, Optional<Double> profitMargin);
    List<Client> getAll ();
    Optional<Client> findById (UUID id);
    void delete (UUID id);

    void addLaborToProject(Project project, Labor labor);
    void addMaterialToProject(Project project, Material material);
}
