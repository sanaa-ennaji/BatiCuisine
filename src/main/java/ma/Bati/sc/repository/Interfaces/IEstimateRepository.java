package main.java.ma.Bati.sc.repository.Interfaces;

import main.java.ma.Bati.sc.model.Estimate;

import java.util.Optional;
import java.util.UUID;

public interface IEstimateRepository {
    void save(Estimate estimate);
    Optional<Estimate> findById(UUID id);
}
