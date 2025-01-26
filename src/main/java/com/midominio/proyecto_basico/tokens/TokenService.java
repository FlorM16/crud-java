package com.midominio.proyecto_basico.tokens;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
	@Autowired
    private TokenRepository tokenRepository;

	public String generateToken(String clientId) {
        String token = UUID.randomUUID().toString().replace("-", "") + UUID.randomUUID().toString().replace("-", "");
        
        Optional<Token> existingToken = tokenRepository.findById(token);
        if (existingToken.isPresent()) {
            return generateToken(clientId);  
        }

        Token newToken = new Token();
        newToken.setToken(token);
        newToken.setClientId(clientId);
        tokenRepository.save(newToken);
        return token;
    }
	
	public Optional<Token> findTokenByClientId(String clientId) {
	    return tokenRepository.findByClientId(clientId);
	}

    public Optional<Token> findTokenByValue(String tokenValue) {
        return tokenRepository.findById(tokenValue);
    }
}