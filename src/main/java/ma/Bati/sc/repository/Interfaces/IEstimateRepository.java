package main.java.ma.Bati.sc.repository.Interfaces;

public interface IEstimateRepository {
    void save(Estimate estimate);
    Optional<Estimate> findById(UUID id);
}
