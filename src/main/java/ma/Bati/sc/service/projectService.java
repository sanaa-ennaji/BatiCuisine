package main.java.ma.Bati.sc.service;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.repository.Interfaces.ILaborRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;
import main.java.ma.Bati.sc.service.IService.IProjectService;

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
    public Project create(Client client) {
        return null;
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
