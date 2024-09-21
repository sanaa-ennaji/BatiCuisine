package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.exception.DatabaseException;
import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class clientRepository implements IClientRepository {
  private final Connection connection ;
    public  clientRepository(){
   this.connection = DatabaseConnection.getInstance().getConnection();

    }

    @Override
    public Client save(Client client) {
        String query = "INSERT INTO clients (id, name, address, phone, isProfessional) VALUES(?, ?, ?, ?, ?)";
        try ( PreparedStatement prst = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            prst.setObject(1, client.getId());
            prst.setString(1, client.getName());
            prst.setString(2,client.getAddress());
            prst.setString(3, client.setPhone());
            prst.setBoolean(4, client.getIsProfessional());



        } catch (SQLException e) {
            throw new DatabaseException("Error saving the client", e);
        }
        return client;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
          while (rs.next()){
              Client client = mapResultSetToClient(rs);
              clients.add(client);
          }
        } catch (SQLException e) {
            throw new DatabaseException("Error fetching clients", e);
        }
        return List.of();
    }

    @Override
    public Optional<Client> getById(UUID id) {
        return Optional.empty();
    }


    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(UUID id) {

    }
}
