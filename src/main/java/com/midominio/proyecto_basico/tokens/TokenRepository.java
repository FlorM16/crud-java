package com.midominio.proyecto_basico.tokens;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> findByClientId(String clientId); 

}
