package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Material;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class materialRepository implements IMaterialRepository {
    private final Connection connection;

    public materialRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public Material save(Material material, UUID id) throws SQLException {

        String sql = "INSERT INTO material (id, name, quantity, unitCost, transportCost, qualityCoefficient, project_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, material.getId());
            stmt.setString(2, material.getName());
            stmt.setDouble(3, material.getQuantity());
            stmt.setDouble(4, material.getUnitCost());
            stmt.setDouble(5, material.getTransportCost());
            stmt.setDouble(6, material.getQualityCoefficient());
            stmt.setObject(7, material.getProject().getId());
            stmt.executeUpdate();
        }
        return material;
    }

//    @Override
//    public List<Material> getAll() {
//
//
//        return List.of();
//    }

    @Override
    public Optional<Material> getById(UUID id) {
        return Optional.empty();
    }
}
