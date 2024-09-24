package main.java.ma.Bati.sc.service.IService;

import main.java.ma.Bati.sc.model.Estimate;

import java.util.Optional;
import java.util.UUID;

public interface IEstimateService {
    void create(Estimate estimate);
    Optional<Estimate> findById(UUID id);
}
