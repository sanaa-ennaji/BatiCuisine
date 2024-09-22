package main.java.ma.Bati.sc.repository.Interfaces;

import main.java.ma.Bati.sc.model.Material;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IMaterialRepository {
    Material save (Material material) throws SQLException;
    List<Material> getAll();
    Optional<Material> getById(UUID id);
}
