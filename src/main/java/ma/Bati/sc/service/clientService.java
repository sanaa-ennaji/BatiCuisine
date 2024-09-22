package main.java.ma.Bati.sc.service;

import main.java.ma.Bati.sc.model.Client;
import main.java.ma.Bati.sc.repository.Interfaces.IClientRepository;
import main.java.ma.Bati.sc.service.IService.IClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class clientService  implements IClientService{
  private final IClientRepository clientRepository;
    public clientService (IClientRepository clientRepository){

        this.clientRepository = clientRepository;
    }


    @Override
    public Client create(Client client) {
        if (client.getName() == null || client.getName().trim().isEmpty()){
            throw new IllegalArgumentException("client name is empty ");
        }
        if(client.getAddress() == null || client.getAddress().trim().isEmpty()){
            throw new IllegalArgumentException("client addres is empty ");
        }
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }

    @Override
    public Optional<Client> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void delete(UUID id) {

    }
}
