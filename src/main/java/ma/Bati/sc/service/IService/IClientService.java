package main.java.ma.Bati.sc.service.IService;

import main.java.ma.Bati.sc.model.Client;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IClientService {

    Client create(Client client);
    List<Client> getAll ();
    Optional<Client> findById (UUID id);
    void delete (UUID id);
     List<Client> findByName(String name);

}
