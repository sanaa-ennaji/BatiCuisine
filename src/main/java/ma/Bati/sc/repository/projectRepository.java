package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.Enums.ProjectState;
import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Project;
import main.java.ma.Bati.sc.repository.Interfaces.IProjectRepository;

import java.sql.*;
import java.util.ArrayList;
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

            String sql = "INSERT INTO projects (id, projectName, profitMargin, projectState, surface, client_id) VALUES (?, ?, ?,  ?::project_state_enum, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setObject(1, project.getId());
                stmt.setString(2, project.getProjectName());
                if (project.getProfitMargin().isPresent()) {
                    stmt.setDouble(3, project.getProfitMargin().get());
                } else {
                    stmt.setNull(3, java.sql.Types.DOUBLE);
                }
                stmt.setString(4, project.getProjectState().name());
                stmt.setDouble(5, project.getSurface());
                    stmt.setObject(6, project.getClient().getId());

            return project;
        }

}

    @Override
    public List<Project> getAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();
        String sql = "SELECT * FROM projects";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Project project = new Project();
                project.setId(UUID.fromString(rs.getString("id")));
                project.setProjectName(rs.getString("projectName"));
                project.setProfitMargin(rs.getDouble("profitMargin"));

                ProjectState projectState = ProjectState.valueOf(rs.getString("projectState"));
                project.setProjectState(projectState);

                project.setSurface(rs.getDouble("surface"));

                projectList.add(project);
            }
        }

        return projectList;
    }


    @Override
    public Optional<Project> getById(UUID id) {
        return Optional.empty();
    }
}
