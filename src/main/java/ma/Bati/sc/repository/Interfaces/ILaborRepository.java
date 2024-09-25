package main.java.ma.Bati.sc.repository.Interfaces;

import main.java.ma.Bati.sc.model.Labor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ILaborRepository {
    Labor save (Labor labor, UUID id) throws SQLException;
  //  List<Labor> getAll();
    Optional<Labor> getById(UUID id);
}
