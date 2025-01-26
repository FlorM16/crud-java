package com.midominio.proyecto_basico.tokens;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.midominio.proyecto_basico.clients.ClientService;
import com.midominio.proyecto_basico.utils.ApiResponse;

import com.midominio.proyecto_basico.clients.Client;

@RestController
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/token")
    public ResponseEntity<?> getToken(@RequestHeader String clientId, @RequestHeader String clientSecret) {
        Optional<Client> clientOpt = clientService.findClientByIdAndSecret(clientId, clientSecret);
        if (clientOpt.isPresent()) {
        	
        	Optional<Token> existingTokenOpt = tokenService.findTokenByClientId(clientId);
            
            if (existingTokenOpt.isPresent()) {
                String token = existingTokenOpt.get().getToken();
                TokenDTO tokenDTO = new TokenDTO(token);
                return ResponseEntity.ok(tokenDTO);
            } else {
                return ResponseEntity.status(500).body(new ApiResponse(500, "Internal Error"));
            }
        }
        return ResponseEntity.status(500).body(new ApiResponse(500, "Internal Error"));
    }
    
    @GetMapping("/introspect")
    public ResponseEntity<ApiResponse> introspectToken(@RequestHeader String token) {
        Optional<Token> tokenOpt = tokenService.findTokenByValue(token);
        
        if (tokenOpt.isPresent()) {
         
            Token tokenEntity = tokenOpt.get();
            TokenDTO tokenDTO = new TokenDTO(tokenEntity.getToken()); 
            String clientId = tokenEntity.getClientId(); 
            
            return ResponseEntity.ok(new ApiResponse(200, "Success", clientId));
        }
        
        return ResponseEntity.status(400).body(new ApiResponse(400, "Error"));
    }
    }