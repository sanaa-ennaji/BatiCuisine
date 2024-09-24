package main.java.ma.Bati.sc.service;

import main.java.ma.Bati.sc.model.Estimate;
import main.java.ma.Bati.sc.repository.Interfaces.IEstimateRepository;
import main.java.ma.Bati.sc.service.IService.IEstimateService;

import java.util.Optional;
import java.util.UUID;

public class EstimateService implements IEstimateService {
    private  final IEstimateRepository estimateRepository;

    public EstimateService(IEstimateRepository estimateRepository) {
        this.estimateRepository = estimateRepository;
    }

    @Override
    public void create(Estimate estimate) {
        estimateRepository.save(estimate);
    }

    @Override
    public Optional<Estimate> findById(UUID id) {
        return estimateRepository.findById(id);

    }
}
