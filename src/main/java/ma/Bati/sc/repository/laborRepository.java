package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Labor;
import main.java.ma.Bati.sc.repository.Interfaces.ILaborRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class laborRepository implements ILaborRepository {
    private final Connection connection ;

    public laborRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Labor save(Labor labor, UUID id) throws SQLException {

        String sql = "INSERT INTO labor (id, name, VATRate, hourlyRate, workHours, workEfficiency, project_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, labor.getId());
            stmt.setString(2, labor.getName());
            stmt.setDouble(3, labor.getVATRate());
            stmt.setDouble(4, labor.getHourlyRate());
            stmt.setDouble(5, labor.getWorkHours());
            stmt.setDouble(6, labor.getWorkEfficiency());
            stmt.setObject(7, labor.getProject().getId());
            stmt.executeUpdate();
        }
        return labor;
    }

    @Override
    public List<Labor> getAll() {
        return List.of();
    }

    @Override
    public Optional<Labor> getById(UUID id) {
        return Optional.empty();
    }
}
