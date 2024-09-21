package main.java.ma.Bati.sc.repository;

import main.java.ma.Bati.sc.config.DatabaseConnection;
import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;

import java.sql.Connection;
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
        return null;
    }

    @Override
    public List<Client> getAll() {
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
