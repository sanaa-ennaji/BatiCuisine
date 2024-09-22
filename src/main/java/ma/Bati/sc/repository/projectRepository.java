package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class projectRepository implements IProjectRepository {
private final Connection connection;

    public projectRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Project save(Project project) throws SQLException {

            String sql = "INSERT INTO projects (id, projetName, profitMargin, projectState, client_id) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setObject(1, project.getId());
                stmt.setString(2, project.getProjectName());
                stmt.setDouble(3, project.getProfitMargin());
                stmt.setString(4, project.getProjectState().name());
                stmt.setObject(5, project.getClient().getId());
                stmt.executeUpdate();
            }
        }



    @Override
    public List<Project> getAll() {
        return List.of();
    }

    @Override
    public Optional<Project> getById(UUID id) {
        return Optional.empty();
    }
}
