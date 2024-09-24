package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Estimate;
import main.java.ma.Bati.sc.repository.Interfaces.IEstimateRepository;

import java.sql.Connection;
import java.util.Optional;
import java.util.UUID;

public class estimateRepository implements IEstimateRepository {

    private final Connection connection;

    public estimateRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void save(Estimate estimate) {

    }

    @Override
    public Optional<Estimate> findById(UUID id) {
        return Optional.empty();
    }
}
