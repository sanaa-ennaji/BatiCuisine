package main.java.ma.Bati.sc.repository.Interfaces;

import main.java.ma.Bati.sc.model.Project;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IProjectRepository {

   Project save (Project project) throws SQLException;
   List<Project> getAll();
   Optional<Project> getById(UUID id);




}
