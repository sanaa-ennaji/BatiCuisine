package main.java.ma.Bati.sc.service;

import main.java.ma.Bati.sc.Enums.ProjectState;
import main.java.ma.Bati.sc.model.Client;
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
        this.projectRepository = projectRepository;
        this.materialRepository = materialRepository;
        this.laborRepository = laborRepository;
    }


    @Override
    public Project create(String projectName, double surface, Client client) {
        UUID projectId = UUID.randomUUID();
        Project project = new Project();
        project.setId(UUID.randomUUID());
        project.setProjectName(projectName);
        project.setSurface(surface);
        project.setClient(client);
        project.setProfitMargin(0.0);
        project.setTotalCost(0.0);
        project.setProjectState(ProjectState.IN_PROGRESS);

        return project;


    }

    @Override
    public void save(Project project) throws SQLException {
        projectRepository.save(project);
        project.getMaterials().forEach(material -> {
            try {
                materialRepository.save(material, project.getId());
            } catch (SQLException e) {        e.printStackTrace();
            }
        });
        project.getLabors().forEach(labor -> {
            try {
                laborRepository.save(labor, project.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public double calculateTotalCost(Project project, Optional<Double> VATRate, Optional<Double> profitMargin) {
        return 0;
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {

    }
}
