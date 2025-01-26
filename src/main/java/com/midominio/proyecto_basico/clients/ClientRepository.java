package com.midominio.proyecto_basico.clients;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findByClientIdAndClientSecret(String clientId, String clientSecret);

}
