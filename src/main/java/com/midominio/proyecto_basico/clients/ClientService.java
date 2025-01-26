package com.midominio.proyecto_basico.clients;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findClientById(String clientId) {
        return clientRepository.findById(clientId);
    }

    public void saveClient(Client client) {
        clientRepository.save(client);
    }
    
    public Optional<Client> findClientByIdAndSecret(String clientId, String clientSecret) {
        return clientRepository.findByClientIdAndClientSecret(clientId, clientSecret);
    }

}
