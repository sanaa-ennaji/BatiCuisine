package main.java.ma.Bati.sc.service.IService;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectService
{
    Project create(String projectName, double surface, UUID clientId);
    List<Client> getAll ();
    Optional<Client> findById (UUID id);
    void delete (UUID id);
}
