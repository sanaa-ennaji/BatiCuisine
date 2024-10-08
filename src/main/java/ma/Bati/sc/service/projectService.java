package main.java.ma.Bati.sc.service;

import main.java.ma.Bati.sc.Enums.ProjectState;
import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Labor;
import main.java.ma.Bati.sc.model.Material;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.repository.Interfaces.ILaborRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
import main.java.ma.Bati.sc.service.IService.IProjectService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class projectService implements IProjectService {
    private final IProjectRepository projectRepository;
    private final IMaterialRepository materialRepository;
    private final ILaborRepository laborRepository;


    public projectService(IProjectRepository projectRepository, IMaterialRepository materialRepository, ILaborRepository laborRepository) {
        this.projectRepository =  projectRepository;
        this.materialRepository = materialRepository;
        this.laborRepository = laborRepository;
    }




    public Project create(String projectName, double surface, Optional<Client> client) {
        UUID projectId = UUID.randomUUID();
        Project project = new Project();
        project.setId(projectId);
        project.setProjectName(projectName);
        project.setSurface(surface);

        if (client.isPresent()) {
            project.setClient(client.get());
        } else {
            throw new IllegalArgumentException("Client cannot be null");
        }

        project.setProfitMargin(0.0);
        project.setTotalCost(0.0);
        project.setProjectState(ProjectState.IN_PROGRESS);

        return project;
    }



    @Override
    public void save(Project project) throws SQLException {
        projectRepository.save(project);
        for (Material material : project.getMaterials()) {
            materialRepository.save(material, project.getId());
        }
        for (Labor labor : project.getLabors()) {
            laborRepository.save(labor, project.getId());
        }
    }




    public void addMaterialToProject(Project project, Material material) {
        project.getMaterials().add(material);

    }


    public void addLaborToProject(Project project, Labor labor) {
        project.getLabors().add(labor);
    }

    @Override
    public double calculateTotalCost(Project project, Optional<Double> profitMargin) {

        double materialCost = project.getMaterials().stream()
                .mapToDouble(material -> material.calculateTotalCost() + (material.calculateTotalCost() * material.getVATRate() / 100))
                .sum();

        double laborCost = project.getLabors().stream()
                .mapToDouble(labor -> labor.calculateTotalCost() + (labor.calculateTotalCost() * labor.getVATRate() / 100))
                .sum();


        double totalCost = materialCost + laborCost;

        if (profitMargin.isPresent()) {
            totalCost += totalCost * (profitMargin.get() / 100);
        }

        return totalCost;
    }

    @Override
    public List<Project> getAll() throws SQLException {
        return projectRepository.getAll();
    }
  // mise en situation
@Override
public List<Project> getAll() throws SQLException {
    List<Project> allProjects = projectRepository.getAll();
    
    return allProjects.stream()
            .filter(project -> "completed".equalsIgnoreCase(project.getProjectState()))
            .collect(Collectors.toList());
}



}
