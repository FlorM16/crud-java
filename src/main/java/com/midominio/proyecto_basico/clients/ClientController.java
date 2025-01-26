package com.midominio.proyecto_basico.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public Object createClient(@RequestParam String clientId, @RequestParam String clientSecret) {
        if (clientService.findClientById(clientId).isPresent()) {
            return new Object() {
                public int status = 400;
                public String message = "Client already exists";
            };
        }

        Client client = new Client();
        client.setClientId(clientId);
        client.setClientSecret(clientSecret);

        clientService.saveClient(client);

        return new Object() {
            public int status = 200;
            public String message = "Success";
        };
    }
}