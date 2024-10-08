package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Estimate;
import main.java.ma.Bati.sc.repository.Interfaces.IEstimateRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

public class estimateRepository implements IEstimateRepository {

    private final Connection connection;

    public estimateRepository() {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    @Override
    public void save(Estimate estimate) {
        String query = "INSERT INTO estimates (id, estimatedAmount, issueDate, validationDate, accepted, project_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setObject(1, estimate.getId());
            pstmt.setDouble(2, estimate.getEstimatedAmount());
            pstmt.setDate(3, java.sql.Date.valueOf(estimate.getIssueDate()));
            pstmt.setDate(4, java.sql.Date.valueOf(estimate.getValidatyDate()));
            pstmt.setBoolean(5, estimate.getIsAccepted());
            pstmt.setObject(6, estimate.getProject().getId());

            pstmt.executeUpdate();
            System.out.println("Estimate saved successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error saving estimate: " + e.getMessage());
        }

    }

    @Override
    public Optional<Estimate> findById(UUID id) {
        String query = "SELECT * FROM estimates WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setObject(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Estimate estimate = new Estimate();
                estimate.setId((UUID) rs.getObject("id"));
                estimate.setEstimatedAmount(rs.getDouble("estimated_amount"));
                estimate.setIssueDate(rs.getDate("issue_date").toLocalDate());
                estimate.setValidatyDate(rs.getDate("validaty_date").toLocalDate());
                estimate.setAccepted(rs.getBoolean("accepted"));
                // estimate.setProject(retrieveProjectById(rs.getObject("project_id")));

                return Optional.of(estimate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error finding estimate by ID: " + e.getMessage());
        }

        return Optional.empty();
    }
}
