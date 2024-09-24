package main.java.ma.Bati.sc.repository.Interfaces;

import main.java.ma.Bati.sc.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientRepository {
    List <Client>  getAll ();
    Optional <Client> getById(UUID id);
    Client save (Client client);
    void update(Client client);
    void delete (UUID id);
      List<Client> findByName(String name);

}

