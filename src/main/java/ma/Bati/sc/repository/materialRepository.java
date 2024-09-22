package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Material;
import main.java.ma.Bati.sc.repository.Interfaces.IMaterialRepository;

import java.sql.Connection;
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
    public Material save(Material material) throws SQLException {
        return null;
    }

    @Override
    public List<Material> getAll() {
        return List.of();
    }

    @Override
    public Optional<Material> getById(UUID id) {
        return Optional.empty();
    }
}
